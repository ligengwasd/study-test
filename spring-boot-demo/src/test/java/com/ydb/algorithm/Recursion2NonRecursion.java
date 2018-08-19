package com.ydb.algorithm;

/**
 * 递归转非递归
 * @Author ligeng
 * @Date 18/8/19
 * @Time 下午8:36
 */
public class Recursion2NonRecursion {
    public static void main(String[] args) {
        long time1 = System.currentTimeMillis();
        System.out.println(f2(40));
        long time2 = System.currentTimeMillis();
        System.out.println(f(40));
        long time3 = System.currentTimeMillis();

        System.out.println(time2-time1);
        System.out.println(time3-time2);
    }

    //斐波那契数列
    //递归
    private static int f(int n) {
        if (n==1 || n==0) return 1;
        else return f(n-1)+f(n-2);
    }


    //非递归
    private static int f2(int n) {

        if(n<0){
            return -1;
        } else if(n<3) {
            return 1;
        } else {
            int s=0;
            int s1=1, s2=1;
            for (int i=2; i<=n; i++) {
                s=s1+s2;
                s2=s1; // 保存f(n-2)的值
                s1=s; //保存f(n-1)的值
            }
            return s;
        }

    }
}
