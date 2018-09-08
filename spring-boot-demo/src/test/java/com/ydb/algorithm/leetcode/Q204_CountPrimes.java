package com.ydb.algorithm.leetcode;

/**
 * @Author ligeng
 * @Date 18/9/8
 * @Time 下午11:18
 */
public class Q204_CountPrimes {
    public static void main(String[] args) {
        System.out.println(countPrimes(12));
    }

    public static int countPrimes(int n) {
        if (n<=2) return 0;
        if (n==3) return 1;
        int count = 0;
        for (int i=2; i<=(n+1)/2; i++) {

            for (int j=i; j<=(n+1)/2; j++) {
                if (i*j < n) {
                    count++;
                }
            }
        }
        return n - count- 2;
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
