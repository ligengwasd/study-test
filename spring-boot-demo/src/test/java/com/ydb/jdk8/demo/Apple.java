package com.ydb.jdk8.demo;

import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

/**
 * 函数式编程
 * @Author ligeng
 * @Date 19/8/23
 * @Time 下午4:28
 */
@Data
public class Apple {
    private String color;
    private int weight;

    public boolean isGreen() {
        return "green".equals(color);
    }

    public boolean isHeavy() {
        return weight > 150;
    }

    public static void main(String[] args) {
        List<Apple> list = new ArrayList<>();

        filter(list, Apple::isGreen);
        filter(list, (Apple a)-> "green".equals(a.color));

        list.sort(Comparator.comparing(Apple::getWeight));

        List<String> str = Arrays.asList("a", "b");
        str.sort((s1, s2)->s1.compareTo(s2));
        str.sort(String::compareTo);

        int j= 10;
        IntPredicate p = (i) -> i>j;
//        j=100;

    }

    public static List<Apple> filter(List<Apple> list, Predicate<Apple> p) {
        List<Apple> res = new ArrayList<>();
        for (Apple apple : list) {
            if (p.test(apple)) res.add(apple);
        }
        return res;
    }
}
