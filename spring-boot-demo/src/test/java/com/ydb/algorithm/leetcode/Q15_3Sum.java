package com.ydb.algorithm.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @Author ligeng
 * @Date 18/9/13
 * @Time 下午12:16
 */
public class Q15_3Sum {
    public static void main(String[] args) {
        List<List<Integer>> lists = threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println(1);
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();

        Arrays.sort(nums);
        for(int i=0; i<nums.length-2; i++) {
            int j=i+1, k=nums.length-1;
            while (j<k) {
                int sum = nums[i]+nums[j]+nums[k];
                if (sum>0) {
                    k--;
                } else if (sum<0) {
                    j++;
                } else {
                    set.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    k--;
                }
            }
        }
        return set.stream().collect(Collectors.toList());
    }
}
