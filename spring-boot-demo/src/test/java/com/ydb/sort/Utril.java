package com.ydb.sort;

/**
 * Created by ligeng on 17/11/27.
 */
public class Utril {
    static void swap(int s[], int i, int j){
        int temp;
        temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }
    static void print(int[] s){
        for (int t:s){
            System.out.print(t+",");
        }
        System.out.println();
    }
}
