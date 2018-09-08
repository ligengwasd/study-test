package com.ydb.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author ligeng
 * @Date 18/9/8
 * @Time 下午11:18
 */
public class Q204_CountPrimes {
    public static void main(String[] args) {
        System.out.println(countPrimes(10));
    }

    public static int countPrimes(int n) {
        boolean[] notPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (notPrime[i] == false) {
                count++;
                for (int j = 2; i*j < n; j++) {
                    notPrime[i*j] = true;
                }
            }
        }

        return count;
    }


    // 性能差的解法
    public static int countPrimes2(int n) {
        int count = 0;
        for (int i=2;i<n; i++) {
            if (isPrime(i)) count++;
        }
        return count;
    }
    public static boolean isPrime(int n){
        for(int i=2;i<=n/2;i++){
            if(n%i == 0)
                return false;
        }
        return true;
    }
}
