package com.ydb.jdk8.demo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
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
        filter(new ArrayList<>(), Apple::isGreen);
    }

    public static List<Apple> filter(List<Apple> list, Predicate<Apple> p) {
        List<Apple> res = new ArrayList<>();
        for (Apple apple : list) {
            if (p.test(apple)) res.add(apple);
        }
        return res;
    }
}
