package com.ydb.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author ligeng
 * @Date 18/9/18
 * @Time 上午9:37
 */
public class Q120_Triangle {
    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3,4));
        triangle.add(Arrays.asList(5,6,7));
//        triangle.add(Arrays.asList(4,1,8,3));

        System.out.println(minimumTotal(triangle));
    }



    public static int minimumTotal(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.size()+1];
        for (int i=triangle.size()-1; i>=0; i--) {
            for (int j=0; j< triangle.get(i).size(); j++) {
                dp[j] = Math.min(dp[j], dp[j+1])+triangle.get(i).get(j);
            }
        }
        return dp[0];
    }
//    public static int minimumTotal(List<List<Integer>> triangle) {
//        int[] A = new int[triangle.size()+1];
//        for(int i=triangle.size()-1;i>=0;i--){
//            for(int j=0;j<triangle.get(i).size();j++){
//                A[j] = Math.min(A[j],A[j+1])+triangle.get(i).get(j);
//            }
//        }
//        return A[0];
//    }
}
