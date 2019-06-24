package com.ydb.sort.quicksort;

import com.ydb.sort.Util;

/**
 * @Author ligeng
 * @Date 19/6/24
 * @Time 下午4:27
 */
public class QuickSort3Way {

    public static void QuickSort3Way(int[] A, int L, int R){
        if(L >= R){//递归终止条件，少于等于一个元素的数组已有序
            return;
        }

        int i,j,k,pivot;
        pivot = A[L]; //首元素作为中轴
        i = L;
        k = L+1;
        j = R;

        OUT_LOOP:
        while(k <= j){
            if(A[k] < pivot){
                Util.swap(A, i, k);
                i++;
                k++;
            }else
            if(A[k] == pivot){
                k++;
            }else{// 遇到A[k]>pivot的情况，j从右向左扫描
                while(A[j] > pivot){//A[j]>pivot的情况,j继续向左扫描
                    j--;
                    if(j < k){
                        break OUT_LOOP;
                    }
                }
                if(A[j] == pivot){//A[j]==pivot的情况
                    Util.swap(A, k, j);
                    k++;
                    j--;
                }else{//A[j]<pivot的情况
                    Util.swap(A, i, j);
                    Util.swap(A, j, k);
                    i++;
                    k++;
                    j--;
                }
            }
        }
        //A[i, j] 等于 pivot 且位置固定，不需要参与排序
        QuickSort3Way(A, L, i-1); // 对小于pivot的部分进行递归
        QuickSort3Way(A, j+1, R); // 对大于pivot的部分进行递归
    }
}
