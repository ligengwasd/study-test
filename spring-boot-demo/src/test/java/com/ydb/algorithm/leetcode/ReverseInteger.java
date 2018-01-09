package com.ydb.algorithm.leetcode;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by ligeng on 18/1/9.
 * Given a 32-bit signed integer, reverse digits of an integer.

 Example 1:

 Input: 123
 Output:  321
 Example 2:

 Input: -123
 Output: -321
 Example 3:

 Input: 120
 Output: 21
 Note:
 Assume we are dealing with an environment which could only hold integers within the 32-bit signed integer range. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 */
public class ReverseInteger {
    public static void main(String[] args) {
        System.out.println(reverse(123));
    }

    public static int reverse(int x) {
        List<Long> list = new ArrayList<>();
        Long temp = (x==-2147483648) ? 2147483648L : new Long(Math.abs(x));
        if (temp < 10) {
            list.add(temp);
        } else {
            do {
                list.add(temp%10);
                temp = temp/10;
            }while (temp>9);
            list.add(temp);
        }

        Double sum = 0D;
        for (int i=0; i<list.size(); i++){
            sum += list.get(i) * Math.pow(10, list.size()-i-1);
        }
        if (sum > Integer.MAX_VALUE) return 0;
        return x > 0 ? sum.intValue() : -sum.intValue();
    }
}
