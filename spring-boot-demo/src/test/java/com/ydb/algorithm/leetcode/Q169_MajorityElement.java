package com.ydb.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ligeng
 * @Date 18/9/3
 * @Time 上午1:52
 */
public class Q169_MajorityElement {
    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{2,2,1,1,1,2,2}));
    }
    public static int majorityElement(int[] nums) {
        Map<String, Integer> map = new HashMap<>();
        int halfLength = nums.length/2;
        for (int num : nums) {
            String key = num +"";
            Integer count = map.get(key);
            if (count == null) count = 0;
            if ((count+1) > halfLength) {
                return num;
            }
            map.put(key, count +1);
        }
        return -1;
    }
}
