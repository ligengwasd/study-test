package com.ydb.jdk8.demo.stream;

import lombok.Data;

import java.util.*;

import static java.util.stream.Collectors.*;

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
    public enum CaloricLevel{
        DIET, NORMAL, FAT
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

//        --------------------------------------收集器--------------------------------------
        // toCollection()
        menu.stream().collect(toCollection(ArrayList::new));
        // counting()
        menu.stream().collect(counting());
        // summarizingInt()
        menu.stream().collect(summarizingInt(Dish::getCalories));
        // summarizingLong()
        menu.stream().collect(summarizingLong((Dish::getCalories)));
        // averagingInt()
        menu.stream().collect(averagingInt(Dish::getCalories));
        // summarizingInt()
        IntSummaryStatistics intSummaryStatistics = menu.stream().collect(summarizingInt(Dish::getCalories));
        // joining()
        menu.stream().map(Dish::getName).collect(joining(","));
        // maxBy()
        menu.stream().collect(maxBy(Comparator.comparingInt(Dish::getCalories)));
        // reducing()
        menu.stream().collect(reducing(0, Dish::getCalories, Integer::sum));
        // collectingAndThen()
        menu.stream().collect(collectingAndThen(toList(), List::size));
        // partitioningBy()
        menu.stream().collect(partitioningBy(Dish::isVegetarian, toSet()));

        // groupingBy() 取分组中有多少条数据
        Map<Type, Long> map2 = menu.stream().collect(groupingBy(Dish::getType, counting()));
        // groupingBy() 取分组中做大的
        Map<Type, Optional<Dish>> map1 = menu.stream().collect(groupingBy(Dish::getType, maxBy(Comparator.comparing(Dish::getCalories))));
        // groupingBy() 取分组中做大的，并且进一步处理去掉Optional
        Map<Type, Dish> map3 = menu.stream().collect(
                groupingBy(Dish::getType, collectingAndThen(maxBy(Comparator.comparing(Dish::getCalories)), Optional::get)));
        System.out.println(map3);
        // groupingBy() 多级分组
        Map<Type, Map<Integer, List<Dish>>> map = menu.stream().collect(groupingBy(Dish::getType, groupingBy(dish -> {
            if (dish.getCalories() > 500) return 1;
            else return 0;
        })));
        // groupingBy联合使用的其他收集器的例子
        Map<Dish.Type, Set<CaloricLevel>> caloricLevelsByType =
                menu.stream().collect(
                        groupingBy(Dish::getType, mapping(
                                dish -> {
                                    if (dish.getCalories() <= 400) return CaloricLevel.DIET;
                                    else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
                                    else return CaloricLevel.FAT;
                                },
                                toCollection(HashSet::new) )));

    }
}
