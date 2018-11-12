package com.ydb.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ligeng
 * @Date 18/11/11
 * @Time 下午7:26
 */
public class Q78_Subsets {
    public static void main(String[] args) {
        Q78_Subsets subsets = new Q78_Subsets();
        List<List<Integer>> list = subsets.subsets(new int[]{1, 2, 3});
        System.out.println(1);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for(int n : nums){
            int size = result.size();
            for(int i=0; i<size; i++){
                List<Integer> subset = new ArrayList<>(result.get(i));
                subset.add(n);
                result.add(subset);
            }
        }
        return result;
    }
}
