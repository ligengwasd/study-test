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
        System.out.println(f2(10));
        long time2 = System.currentTimeMillis();
        System.out.println(f3(10, 1,1));
        long time3 = System.currentTimeMillis();

//        System.out.println(time2-time1);
//        System.out.println(time3-time2);
    }

    //斐波那契数列
    //递归
    private static int f(int n) {
        int res;
        if (n==1 || n==0) {
            res = 1;
        } else {
            res = f(n-1)+f(n-2);
        }
        System.out.print(res+" ");
        return res;
    }

    // 递归转尾递归
    private static int f3(int n, int s1, int s2) {
        System.out.print(s2+" ");
        int res;
        if (n<2) {
            res = s2;
        } else {
            res = f3(n-1, s2, s1+s2);
        }
        return res;
    }
    //递归转循环
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
