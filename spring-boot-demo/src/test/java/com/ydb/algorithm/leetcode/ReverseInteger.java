package com.ydb.algorithm.leetcode;

import org.apache.commons.lang.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ligeng on 18/1/9.
 */
public class ReverseInteger {
    public static void main(String[] args) {
//        1534236469
        System.out.println(reverse(1534236469));
    }

    public static int reverse(int x) {
        List<Integer> list = new ArrayList<>();
        Integer temp = new Integer(Math.abs(x));
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
