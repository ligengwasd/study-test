package com.ydb.algorithm.leetcode;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author ligeng
 * @Date 19/1/11
 * @Time 下午9:53
 */
public class Q128_LongestConsecutiveSequence {
    @Test
    public void test(){
        System.out.println(this.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
    }

    public int longestConsecutive(int[] nums) {
        int res = 0;
        Set<Integer> s = new HashSet<>();
        for (int num : nums) s.add(num);
        for (int num : nums) {
            if (s.remove(num)) {
                int pre = num - 1, next = num + 1;
                while (s.remove(pre)) {
                    --pre;
                }
                while (s.remove(next)) {
                    ++next;
                }
                res = Math.max(res, next - pre - 1);
            }
        }
        return res;
    }
}
