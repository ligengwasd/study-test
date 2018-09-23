package com.ydb.algorithm.leetcode;

/**
 * @Author ligeng
 * @Date 18/9/23
 * @Time 下午8:24
 */
public class Q905_SortArrayByParity {
    public static void main(String[] args) {
        int[] ints = sortArrayByParity(new int[]{2,3,1,2,4});
        System.out.println(ints);
    }
    public static int[] sortArrayByParity(int[] A) {
        int i=0, j=A.length-1;
        while (i<j) {
            while (i<j && A[i]%2 == 0){
                i++;
            }
            while (i<j && A[j]%2 != 0) {
                j--;
            }
            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;
        }
        return A;
    }
}
