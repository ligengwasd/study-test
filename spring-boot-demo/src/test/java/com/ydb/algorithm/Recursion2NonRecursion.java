package com.ydb.algorithm;

import java.util.Stack;

/**
 * 递归转非递归
 * @Author ligeng
 * @Date 18/8/19
 * @Time 下午8:36
 */
public class Recursion2NonRecursion {
    public static void main(String[] args) {
        int n = 45;
        System.out.println("n="+n);
        long time1 = System.currentTimeMillis();
        System.out.printf("非尾递归，返回值：%s ,时长：%s %n", f1(n), System.currentTimeMillis()-time1);
        long time2 = System.currentTimeMillis();
        System.out.printf("尾递归，返回值：%s ,时长：%s %n",f2(n, 1,1), System.currentTimeMillis()-time2);
        long time3 = System.currentTimeMillis();
        System.out.printf("迭代，返回值：%s ,时长：%s %n", f3(n),System.currentTimeMillis()-time3);
        long time4 = System.currentTimeMillis();
        System.out.printf("使用栈，返回值：%s ,时长：%s %n",f4(n),System.currentTimeMillis()-time4);

    }

    //斐波那契数列
    //递归
    private static int f1(int n) {
        int res;
        if (n==1 || n==0) {
            res = 1;
        } else {
            res = f1(n-1)+ f1(n-2);
        }
        return res;
    }

    // 递归转尾递归
    private static int f2(int n, int s1, int s2) {
        int res;
        if (n<2) {
            res = s2;
        } else {
            res = f2(n-1, s2, s1+s2);
        }
        return res;
    }
    //递归转循环
    private static int f3(int n) {
        if(n<0){
            return -1;
        } else if(n<3) {
            return 1;
        } else {
            int s=0;
            int s1=1, s2=1;
            for (int i=2; i<=n; i++) {
                s=s1+s2;
                s1=s2; // 保存f(n-2)的值
                s2=s; //保存f(n-1)的值
            }
            return s;
        }

    }

    // 使用栈
    private static int f4(int n) {
        Stack<Integer> stack = new Stack<>();
        int s1, s2;
        for (int i=0; i<=n; i++) {
            if (i<2) {
                stack.push(1);
            } else {
                s2 = stack.pop();
                s1 = stack.peek();
                stack.push(s2);
                stack.push(s1+s2);
            }
        }

        return stack.peek();
    }
}
