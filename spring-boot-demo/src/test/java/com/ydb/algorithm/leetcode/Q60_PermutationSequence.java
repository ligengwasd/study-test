package com.ydb.algorithm.leetcode;

import com.ydb.sort.Util;
import org.junit.Test;

/**
 * @Author ligeng
 * @Date 19/1/11
 * @Time 下午9:06
 */
public class Q60_PermutationSequence {
    @Test
    public void test() {
        System.out.println(getPermutation(5,3));
    }

    public String getPermutation(int n, int k) {
        int[] factorial = new int[n];

        //因式分解需要的基数
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                factorial[i] = 1;
                continue;
            }
            factorial[i] = factorial[i - 1] * (i);
        }
        Util.print(factorial);
        return "";
    }

}
