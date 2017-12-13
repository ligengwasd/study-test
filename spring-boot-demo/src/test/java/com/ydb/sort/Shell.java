package com.ydb.sort;

/**
 * Created by ligeng on 17/11/27.
 */
public class Shell {
    public static void main(String[] args) {
        int[] s = {6,1,2,7,9,3,4,5,10,8,20};
        Util.print(s);
        sort(s);
    }

    static void sort(int s[]){
        int gap,i,j;
        for (gap=s.length/2; gap>0; gap/=2){
            for (i=gap; i<s.length; i++){
                for (j=i; j>0 && s[j-gap]>s[j]; j-=gap){
                    Util.swap(s, j-1,j);
                    Util.print(s);
                }
            }
        }
    }
}
