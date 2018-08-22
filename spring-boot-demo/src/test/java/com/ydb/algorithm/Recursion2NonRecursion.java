package com.ydb.algorithm;

import java.math.BigDecimal;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 递归转非递归
 * @Author ligeng
 * @Date 18/8/19
 * @Time 下午8:36
 */
public class Recursion2NonRecursion {
    private static AtomicInteger count1 = new AtomicInteger(0);
    private static AtomicInteger count2 = new AtomicInteger(0);
    public static void main(String[] args) {
        int n = 40;
        System.out.println("n="+n);
        long time1 = System.currentTimeMillis();
        System.out.printf("递归，返回值：%s ,时长：%s, 调用次数%s %n", f1(n), System.currentTimeMillis()-time1, count1.get());
        long time2 = System.currentTimeMillis();
        System.out.printf("递归，返回值：%s ,时长：%s,调用次数%s %n",f2(n, BigDecimal.ONE, BigDecimal.ONE), System.currentTimeMillis()-time2, count2.get());
        long time3 = System.currentTimeMillis();
        System.out.printf("迭代，返回值：%s ,时长：%s %n", f3(n),System.currentTimeMillis()-time3);
    }

    //斐波那契数列递归实现1
    private static BigDecimal f1(int n) {
        count1.addAndGet(1);
        BigDecimal res;
        if (n==1 || n==0) {
            res = BigDecimal.ONE;
        } else {
            res = f1(n-1).add(f1(n-2));
        }
        return res;
    }

    // 斐波那契数列递归实现2
    private static BigDecimal f2(int n, BigDecimal s1, BigDecimal s2) {
        count2.addAndGet(1);
        BigDecimal res;
        if (n<2) {
            res = s2;
        } else {
            res = f2(n-1, s2, s1.add(s2));
        }
        return res;
    }
    //斐波那契数列迭代实现
    private static BigDecimal f3(int n) {
        if(n<2) {
            return BigDecimal.ONE;
        } else {
            BigDecimal s= BigDecimal.ZERO;
            BigDecimal s1 = BigDecimal.ONE, s2= BigDecimal.ONE;
            for (int i=2; i<=n; i++) {
                s= s1.add(s2);
                s1=s2; // 保存f(n-2)的值
                s2=s; //保存f(n-1)的值
            }
            return s;
        }
    }

    // 使用栈
//    private static int f4(int n) {
//        Stack<Integer> stack = new Stack<>();
//        int s1, s2;
//        for (int i=0; i<=n; i++) {
//            if (i<2) {
//                stack.push(1);
//            } else {
//                s2 = stack.pop();
//                s1 = stack.peek();
//                stack.push(s2);
//                stack.push(s1+s2);
//            }
//        }
//
//        return stack.peek();
//    }
}
