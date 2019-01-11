package com.ydb.algorithm.leetcode;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author ligeng
 * @Date 19/1/11
 * @Time 下午1:03
 */
public class Q3_LongestSubstringWithoutRepeatingCharacters {
    @Test
    public void test() {
        System.out.println(this.lengthOfLongestSubstring(" "));
    }

    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        Set<Character> set = new HashSet<>();
        int maxSubLength = 0;
        for (int i=0; i<chars.length; i++) {
            for (int j=i; j<chars.length; j++) {
                if (set.contains(chars[j])) {
                    if (maxSubLength < set.size()) {
                        maxSubLength = set.size();
                    }
                    set.clear();
                } else {
                    set.add(chars[j]);
                }
            }
            if (maxSubLength < set.size()) {
                maxSubLength = set.size();
            }
            set.clear();
        }
        return maxSubLength < set.size() ? set.size() : maxSubLength;
    }


}
