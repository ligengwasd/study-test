package com.ydb.sort;

/**
 * Created by ligeng on 17/11/27.
 */
public class Util {
    public static void swap(int s[], int i, int j){
        int temp;
        temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }
    public static void print(int[] s){
        for (int t:s){
            System.out.print(t+",");
        }
        System.out.println();
    }
    public static void print(Integer[] s){
        for (int t:s){
            System.out.print(t+",");
        }
        System.out.println();
    }
}
