package com.ydb.algorithm.leetcode;

import java.io.InputStream;
import java.util.stream.IntStream;

/**
 * @Author ligeng
 * @Date 18/9/9
 * @Time 上午12:32
 */
public class Q268_MissingNumber {
    public static void main(String[] args) {
        System.out.println(missingNumber(new int[]{9,6,4,2,3,5,7,0,1}));
    }
    public static int missingNumber(int[] nums) {
        int n = nums.length;
        return (1+n)*n/2 - IntStream.of(nums).sum();

    }
}
