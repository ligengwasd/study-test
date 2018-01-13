package com.ydb.algorithm.leetcode;

/**
 * Created by ligeng on 18/1/13.
 */
public class ClimbStairs {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.climbStairs3(44));
        System.out.println(solution.climbStairs2(44));
    }
    static class Solution {
        // 递归法，效率太低，运行慢。
        public int climbStairs(int n) {
            if (n==1) return 1;
            if (n==2) return 2;
            return climbStairs(n-1) + climbStairs(n-2);
        }
        // 数组
        public int climbStairs2(int n) {
            if (n==1) return 1;
            if (n==2) return 2;

            int[] array = new int[n];
            array[0] = 1;
            array[1] = 2;
            for (int i=2; i<n; i++) {
                array[i] = array[i-1] + array[i-2];
            }
            return array[n-1];
        }
        // 数组浪费空间，使用三个变量代替
        public int climbStairs3(int n) {
            if (n<4) return n;
            int a = 1, b = 2, c = 3;
            for (int i=4; i<=n; i++){
                a = b;
                c = b + c;
                b = c - a;
            }

            return c;
        }
    }
}
