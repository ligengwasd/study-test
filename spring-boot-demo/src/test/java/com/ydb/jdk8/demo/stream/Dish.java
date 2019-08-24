package com.ydb.jdk8.demo.stream;

import lombok.Data;
import org.springframework.data.mongodb.core.mapreduce.GroupBy;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @Author ligeng
 * @Date 19/8/24
 * @Time 上午11:26
 */
@Data
public class Dish {
    private final String name;
    private final boolean vegetarian;
    private final int calories;
    private final Type type;

    public String toString() {
        return name;
    }

    public enum Type {
        MEAT, FISH, OTHER
    }

    public static void main(String[] args) {
        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH));

        List<String> collect = menu.stream().filter(m -> m.getCalories() > 300)
                .map(Dish::getName)
                .limit(3)
                .collect(Collectors.toList());

        // 返回calories最大的
        menu.stream().collect(Collectors.maxBy(Comparator.comparing(Dish::getCalories)));
        // 分组
        Map<Type, List<Dish>> map = menu.stream().collect(Collectors.groupingBy(Dish::getType));
        // 多级分组
        Map<Type, Map<Integer, List<Dish>>> mapMap = menu.stream().collect(Collectors.groupingBy(Dish::getType, Collectors.groupingBy(
                dish -> {
                    if (dish.getCalories() <= 400) return 0;
                    else return 1;
                }
        )));
        System.out.println(mapMap);

    }
}
