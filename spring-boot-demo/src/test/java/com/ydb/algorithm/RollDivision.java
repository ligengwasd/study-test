package com.ydb.algorithm;

import java.util.Scanner;

/**
 * Created by ligeng on 18/1/9.
 */
public class RollDivision {
    public static void main(String[] args) {
        System.out.println("请输入两个正整数");
        System.out.print("第一个正整数:");
        Scanner scanner = new Scanner(System.in);
        String one = scanner.nextLine();
        int a = Integer.valueOf(one);
        System.out.print("第二个正整数:");
        String two = scanner.nextLine();
        int b = Integer.valueOf(two);
        System.out.println("a = " + a + ", b =" + b);
        // 求最大公约数
        // 1. a%b，令temp为所得余数（0≤r<b）
        // 若 temp = 0，算法结束；b 即为答案。
        // 2. 互换：置 a←b，b←temp，并返回第一步。
        int temp, num1 = a, num2 = b;
        if (a < b) {
            // 互换位置
            temp = b;
            b = a;
            a = temp;
        }
        System.out.println("a = " + a + ", b =" + b);
        while (b != 0) {/* 利用辗除法，直到b为0为止 */
            temp = a % b;
            a = b;
            b = temp;
        }
        System.out.println("最大公约数:" + a);
        // 求最小公倍数
        System.out.println("最小公倍数:" + num1 * num2 / a);
    }
}
