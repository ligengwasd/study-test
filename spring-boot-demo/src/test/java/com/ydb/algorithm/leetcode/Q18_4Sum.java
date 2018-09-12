package com.ydb.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @Author ligeng
 * @Date 18/9/10
 * @Time 下午11:40
 */
public class Q18_4Sum {
    public static void main(String[] args) {
        List<List<Integer>> lists = fourSum(new int[]{-3,-2,-1,0,0,1,2,3}, 0);
        System.out.println();
    }
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);
        for (int i=0; i<nums.length-3; i++) {
            for (int j=i+1; j<nums.length-2; j++) {
                int k=j+1, l=nums.length-1;
                while (k<l) {
                    int sum = nums[i] + nums[j] + nums[k] + nums[l];
                    if (sum > target) {
                        l--;
                    } else if (sum < target){
                        k++;
                    } else {
                        result.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        l--;
                    }
                }
            }
        }
        return result;
    }
}
