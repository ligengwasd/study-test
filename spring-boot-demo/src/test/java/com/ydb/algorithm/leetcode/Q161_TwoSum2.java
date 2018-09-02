package com.ydb.algorithm.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author ligeng
 * @Date 18/9/3
 * @Time 上午12:54
 */
public class Q161_TwoSum2 {
    public static void main(String[] args) {
        int[] ints = twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println();
    }
    public static int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i< numbers.length; i++) {
            map.put(numbers[i], i);
        }
        for (int i=0; i< numbers.length; i++) {
            if (map.keySet().contains(target-numbers[i])){
                res[0] = i+1;
                res[1] = map.get(target-numbers[i])+1;
                return res;
            }
        }

        return res;
    }
}
