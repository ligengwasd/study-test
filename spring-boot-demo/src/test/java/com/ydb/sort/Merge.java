package com.ydb.sort;

/**
 * 归并排序
 * Created by ligeng on 17/11/28.
 */
public class Merge {
    private static final int[] theArray = {11,6,1,2,7,9,3,4,5,10,8};
    public static void main(String[] args) {
        int[] workSpace = new int[theArray.length];
//        merge2(workSpace ,0,5, 9);
        nonRecMerge();
        Util.print(theArray);
    }
    private static void recMerge(int first, int last){
        if (first == last) return;
        int mid = (last+first)/2;
        recMerge(first, mid);
        recMerge(mid+1, last);
//        merge2(workSpace, first, mid+1, last);
        merge3(first, mid+1, last);
    }

    private static void nonRecMerge() {
        int n = theArray.length;
        //步长
        int s = 2;
        int i;
        while(s<=n){
            i=0;
            while(i+s-1<=n-1){
                merge3(i,i+s/2,i+s-1);
                i+=s;
            }
            //处理末尾残余部分
            merge3(i,(i+n+1)/2,n-1);
            s*=2;
        }
        //最后再从头到尾处理一遍
        merge3(0,s/2,n-1);
    }


    /**
     * 自己写的
     * @param left_
     * @param middle_
     * @param right_
     */
    private static void merge3(int left_,int middle_,int right_){
        System.out.println(left_ + " " + middle_ + " "+right_);
        int left=left_, leftBound=middle_-1;
        int right=middle_,rightBound=right_;
        int k=0;
        int workSpace[] = new int[right_-left+1];
        while (left<=leftBound && right<=rightBound){
            if (theArray[left] < theArray[right]){
                workSpace[k++] = theArray[left++];
            } else {
                workSpace[k++] = theArray[right++];
            }
        }
        while (left<=leftBound){
            workSpace[k++] = theArray[left++];
        }
        while (right<=rightBound){
            workSpace[k++] = theArray[right++];
        }
        for (k=0; k<workSpace.length; k++){
            theArray[left_++] = workSpace[k];
        }
//        3,4,5,6,1,2,7,9,10,8,
        Util.print(theArray);
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
