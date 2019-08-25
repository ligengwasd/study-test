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


}
