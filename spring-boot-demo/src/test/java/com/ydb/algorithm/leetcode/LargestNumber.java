package com.ydb.algorithm.leetcode;

import java.util.Arrays;

/**
 * @Author ligeng
 * @Date 19/8/21
 * @Time 下午2:57
 */
public class LargestNumber {
    public static void main(String[] args) {
        LargestNumber solution = new LargestNumber();
        System.out.println(solution.largestNumber(new int[]{3,30,34,5,9}));
    }

    public String largestNumber(int[] nums) {
        final String[] strings = new String[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            strings[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strings, (String s1, String s2) -> {
            String leftRight = s1 + s2;
            String rightLeft = s2 + s1;
            return -leftRight.compareTo(rightLeft);
        });


        StringBuilder sb = new StringBuilder();
        for (final String s : strings) {
            sb.append(s);
        }

        while(sb.charAt(0)=='0' && sb.length()>1){
            sb.deleteCharAt(0);
        }

        return sb.toString();

    }
}
