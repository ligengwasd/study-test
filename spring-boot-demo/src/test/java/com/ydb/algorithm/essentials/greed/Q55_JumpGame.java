package com.ydb.algorithm.essentials.greed;

public class Q55_JumpGame {
    public static void main(String[] args) {
        System.out.println(canJump(new int[]{2,3,1,1,4}));
    }
    public static boolean canJump(int[] nums) {
        int reach=0;// 表示从第i步出发能到达的最远距离
        for (int i=0; i<nums.length-1; i++) {
            if (reach < i) {//前面能到的最远距离小于i，说明走不到第i步。返回false。
                return false;
            }
            if (reach < nums[i] + i) {
                reach = nums[i] + i;// 更新从第i步出发能到达的最远距离。
            }
            if (reach >= nums.length-1) {
                return true;
            }
        }
        return false;

    }
}
