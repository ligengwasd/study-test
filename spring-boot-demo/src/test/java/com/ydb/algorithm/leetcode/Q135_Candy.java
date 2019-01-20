package com.ydb.algorithm.leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author ligeng
 * @Date 19/1/20
 * @Time 下午2:52
 */
public class Q135_Candy {
    @Test
    public void test() {
        int candy = candy(new int[]{1,2,2});
        System.out.println(candy);
    }
    public int candy(int[] ratings) {
        int sum=0;
        int[] array = new int[ratings.length];

        Arrays.fill(array, 1);
        for (int i=1; i<ratings.length; i++) {
            if (ratings[i]>ratings[i-1]) {
                // 比前一个的值大，在前一个的基础上+1
                array[i] = array[i-1] + 1;
            }
        }

        for (int i=ratings.length-2; i>=0; i--) {
            // 比后一个的值大，那么必须比后一个的糖果数多一个，如果没有多一个，在后一个糖果数的基础上+1
            if (ratings[i] > ratings[i+1] && array[i] < array[i+1]+1) {
                array[i] = array[i+1]+1;
            }
        }

        for (int temp:array) {
            sum += temp;
        }
        return sum;
    }
}
