package com.ydb.sort;

/**
 * Created by ligeng on 17/11/27.
 */
public class Insert {
    public static void main(String[] args) {
        int[] s = {6,1,2,7,9,3,4,5,10,8};
        Util.print(s);
        sort(s);
    }

    static void sort(int s[]){
        for (int i=1; i<s.length; i++){
            for (int j= i; j>0 && s[j-1] > s[j]; j--){
                Util.swap(s, j, j-1);
                Util.print(s);
            }
        }
    }
}
