package com.ydb.algorithm.leetcode;

import org.apache.commons.lang.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author ligeng
 * @Date 18/9/2
 * @Time 下午12:55
 */
public class Q113_PascalTriangle {
    public static void main(String[] args) {
        generate(5);
    }
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> data = new ArrayList<>();

        for (int i=0; i< numRows; i++) {
            List<Integer> row = new ArrayList<>();

            if (i==0) {
                row = Arrays.asList(new Integer[]{1});
            } else if (i==1) {
                row = Arrays.asList(new Integer[]{1,1});
            } else {
                List<Integer> preRow = data.get(i-1);
                row.add(1);

                for (int j=0; j<preRow.size()-1; j++) {
                    row.add(preRow.get(j) + preRow.get(j+1));
                }
                row.add(1);

            }
            data.add(row);
        }

        return data;
    }

}
