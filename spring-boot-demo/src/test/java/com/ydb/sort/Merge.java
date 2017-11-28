package com.ydb.sort;

/**
 * 归并排序
 * Created by ligeng on 17/11/28.
 */
public class Merge {
    private static final int[] theArray = {6,1,2,7,9,3,4,5,10,8};
    public static void main(String[] args) {
        int[] workSpace = new int[theArray.length];
//        merge2(workSpace ,0,5, 9);
        recMerge(workSpace, 0, 9);
        Util.print(theArray);
    }
    private static void recMerge(int[] workSpace, int first, int last){
        if (first == last) return;
        int mid = (last+first)/2;
        recMerge(workSpace, first, mid);
        recMerge(workSpace, mid+1, last);
        merge2(workSpace, first, mid+1, last);
    }

    private static void merge2(int workSpace[],int lowPtr, int highPtr, int upperBound){
        int lowBound = lowPtr;
        int mid = highPtr-1;
        int j = 0;
        while (lowPtr<=mid && highPtr<=upperBound){
            if (theArray[lowPtr] < theArray[highPtr]){
                workSpace[j++] = theArray[lowPtr++];
            }else{
                workSpace[j++] = theArray[highPtr++];
            }
        }
        while (lowPtr<=mid) {
            workSpace[j++] = theArray[lowPtr++];
        }
        while (highPtr<=upperBound) {
            workSpace[j++] = theArray[highPtr++];
        }
        for (j=0; j< upperBound-lowBound+1; j++){
            theArray[lowBound+j] = workSpace[j];
        }
        Util.print(theArray);
    }


    // 原理。
    // 将两个队列合并成一个队列。
    private static void merge(int a[], int b[], int c[]){
        int i=0,j=0,k=0;
        while (i<a.length && j<b.length){
            if (a[i] < b[j]) {
                c[k++] = a[i++];
            } else {
                c[k++] = b[j++];
            }
            Util.print(c);
        }

        while (i<a.length){
            c[k++] = a[i++];
            Util.print(c);
        }
        while (j<b.length){
            c[k++] = b[j++];
            Util.print(c);
        }
    }
}
