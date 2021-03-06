package com.ydb.jdk8.demo.stream;

import java.util.*;

import static java.util.stream.Collectors.*;

/**
 * @Author ligeng
 * @Date 19/8/25
 * @Time 上午11:24
 */
public class StreamDemo {
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


        //--------------------------------------过滤器--------------------------------------
        menu.stream().filter(Dish::isVegetarian);
        menu.stream().distinct();
        //-------------------------------------- 切片 --------------------------------------
        menu.stream().limit(0).skip(0);
        //--------------------------------------映射器--------------------------------------
        menu.stream().map(Dish::getName).collect(toList());
        // 扁平化，就是把内部的数组展开
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<Integer>(){{
            add(1);
            add(2);
        }});
        list.add(new ArrayList<Integer>(){{
            add(3);
            add(4);
        }});
        List<Integer> integers = list.stream().flatMap(x -> x.stream()).collect(toList());
        System.out.println(integers);
        //--------------------------------------查找--------------------------------------
        menu.stream().findAny();
        menu.stream().findFirst();
        menu.stream().allMatch(Dish::isVegetarian);
        menu.stream().anyMatch(Dish::isVegetarian);
        //----------------------------求和，最大值，最小值------------------------------------
        menu.stream().map(Dish::getCalories).reduce(1, Integer::sum);
        menu.stream().map(Dish::getCalories).max(Integer::compareTo);//最大值
        menu.stream().map(Dish::getCalories).reduce(Integer::max);//最大值
        menu.stream().map(Dish::getCalories).min(Integer::compareTo);
        //--------------------------------------计数--------------------------------------
        menu.stream().count();
        //--------------------------------------收集器--------------------------------------
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
        Map<Dish.Type, Long> map2 = menu.stream().collect(groupingBy(Dish::getType, counting()));
        // groupingBy() 取分组中做大的
        Map<Dish.Type, Optional<Dish>> map1 = menu.stream().collect(groupingBy(Dish::getType, maxBy(Comparator.comparing(Dish::getCalories))));
        // groupingBy() 取分组中做大的，并且进一步处理去掉Optional
        Map<Dish.Type, Dish> map3 = menu.stream().collect(
                groupingBy(Dish::getType, collectingAndThen(maxBy(Comparator.comparing(Dish::getCalories)), Optional::get)));
        System.out.println(map3);
        // groupingBy() 多级分组
        Map<Dish.Type, Map<Integer, List<Dish>>> map = menu.stream().collect(groupingBy(Dish::getType, groupingBy(dish -> {
            if (dish.getCalories() > 500) return 1;
            else return 0;
        })));
        // groupingBy联合使用的其他收集器的例子
        Map<Dish.Type, Set<Dish.CaloricLevel>> caloricLevelsByType =
                menu.stream().collect(
                        groupingBy(Dish::getType, mapping(
                                dish -> {
                                    if (dish.getCalories() <= 400) return Dish.CaloricLevel.DIET;
                                    else if (dish.getCalories() <= 700) return Dish.CaloricLevel.NORMAL;
                                    else return Dish.CaloricLevel.FAT;
                                },
                                toCollection(HashSet::new) )));

    }
}
