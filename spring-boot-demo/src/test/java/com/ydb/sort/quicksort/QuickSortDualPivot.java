package com.ydb.sort.quicksort;

import com.ydb.sort.Util;

/**
 * @Author ligeng
 * @Date 19/6/24
 * @Time 下午4:41
 */
public class QuickSortDualPivot {

    public static void QuickSortDualPivot(int[] A, int L, int R){
        if(L >= R){
            return;
        }

        if(A[L] > A[R]){
            Util.swap(A, L, R); //保证pivot1 <= pivot2
        }

        int pivot1 = A[L];
        int pivot2 = A[R];

        //如果这样初始化 i = L+1, k = L+1, j = R-1,也可以
        //但代码中边界条件, i,j先增减，循环截止条件，递归区间的边界都要发生相应的改变
        int i = L;
        int k = L+1;
        int j = R;

        OUT_LOOP:
        while(k < j){
            if(A[k] < pivot1){
                i++;//i先增加，首次运行pivot1就不会发生改变
                Util.swap(A, i, k);
                k++;
            }else
            if(A[k] >= pivot1 && A[k] <= pivot2){
                k++;
            }else{
                while(A[--j] > pivot2){//j先增减，首次运行pivot2就不会发生改变
                    if(j <= k){//当k和j相遇
                        break OUT_LOOP;
                    }
                }
                if(A[j] >= pivot1 && A[j] <= pivot2){
                    Util.swap(A, k, j);
                    k++;
                }else{
                    i++;
                    Util.swap(A, j, k);
                    Util.swap(A, i, k);
                    k++;
                }
            }
        }
        Util.swap(A, L, i);//将pivot1交换到适当位置
        Util.swap(A, R, j);//将pivot2交换到适当位置

        //一次双轴切分至少确定两个元素的位置，这两个元素将整个数组区间分成三份
        QuickSortDualPivot(A, L, i-1);
        QuickSortDualPivot(A, i+1, j-1);
        QuickSortDualPivot(A, j+1, R);
    }

}
