package com.ydb.sort.quicksort;

import static com.ydb.sort.Util.print;
import static com.ydb.sort.Util.swap;

/**
 * Created by ligeng on 17/11/25.
 */
public class Quick {
    public static void main(String[] args) {
        int[] s = {6,1,2,7,9,3,4,5,10,8};
        print(s);
        adjustArray(s, 0, s.length-1);
    }
    static void adjustArray(int s[], int left, int right){
        if (left>=right) return;
        int i=left, j=right, x=s[left];
        while (i<j){
            while (i<j && s[j] >= x) {
                // 如果大于x，继续找。
                j--;
            }
            // j的循环必须放在i的循环前面，最终i和j相遇的时候，必须是j向前移动导致的。
            while (i<j && s[i] <= x) {
                // 如果小于x，继续找。
                i++;
            }
            swap(s, i, j);
            print(s);
        }
        // 运行到这里一定是i=j,即找到了中介点  交换x
        swap(s, left, i);
        print(s);
        adjustArray(s, left, i-1);
        adjustArray(s, i+1, right);
    }

}
