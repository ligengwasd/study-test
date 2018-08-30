package com.ydb.sort;

/**
 * @Author ligeng
 * @Date 18/8/30
 * @Time 上午9:35
 */
public class MergeSort2 {
    /**
     * 二路归并排序的递归算法-入口
     *
     * @param <T>
     * @param t
     * @return
     */
    public static <T extends Comparable> boolean mergeSortRecursive(T[] t) {
        if (t == null || t.length <= 1)
            return true;
        MSortRecursive(t, 0, t.length - 1);
        return true;
    }
    /**
     * 二路归并排序的递归算法-递归主体
     *
     * @param <T>
     * @param t
     * @param low
     * @param high
     * @return
     */
    private static <T extends Comparable> boolean MSortRecursive(T[] t,
                                                                 int low, int high) {
        if (t == null || t.length <= 1 || low == high)
            return true;
        int mid = (low + high) / 2;
        MSortRecursive(t, low, mid);
        MSortRecursive(t, mid + 1, high);
        merge(t, low, mid, high);
        return true;
    }
    public static <T extends Comparable> boolean mergeSortNonRecursive(T[] t) {
        if (t == null || t.length <= 1)
            return true;
        int len = 1;
        int low = 0;
        int mid;
        int high;
        // 程序边界的处理非常重要
        while (len <= t.length) {
            for (int i = 0; i + len <= t.length - 1; i += len * 2) {
                //    System.out.println("len="+len);
                low = i;
                mid = i + len - 1;
                high = i + len * 2 - 1;
                if (high > t.length - 1)
                    high = t.length - 1;
                merge(t, i, mid, high);
            }
//长度加倍
            len += len;
        }
        return true;
    }
    /**
     * 将两个归并段合并成一个归并段
     *
     * @param <T>
     * @param t
     * @param low
     * @param mid
     * @param high
     * @return
     */
    private static <T extends Comparable> boolean merge(T[] t, int low,
                                                        int mid, int high) {
        T[] s = t.clone();// 先复制一个辅助数组
        int i, j, k;// 三个指示器，i指示t[low...mid]，j指示t[mid+1...high]，k指示s[low...high]
        for (i = low, j = mid + 1, k = low; i <= mid && j <= high; k++) {
            if (t[i].compareTo(t[j]) <= 0) {
                s[k] = t[i++];
            } else {
                s[k] = t[j++];
            }
        }
        // 将剩下的元素复制到s中
        if (i <= mid) {
            for (; k <= high; k++) {
                s[k] = t[i++];
            }
        } else {
            for (; k <= high; k++) {
                s[k] = s[j++];
            }
        }
        for (int m = low; m <= high; m++) {// 将辅助数组中的排序好的元素复制回原数组
            t[m] = s[m];
        }
        return true;
    }
    public static void main(String[] args) {
        Integer[] arr = new Integer[] { 6,1,2,7,9,3,4,5,10,8 };
        Util.print(arr);

        long startTime = System.currentTimeMillis(); // 获取开始时间
        mergeSortRecursive(arr);
        long endTime = System.currentTimeMillis(); // 获取开始时间
        System.out.println("执行时间：" + (endTime - startTime));
        Util.print(arr);

        startTime = System.currentTimeMillis(); // 获取开始时间
        mergeSortNonRecursive(arr);
        endTime = System.currentTimeMillis(); // 获取开始时间
        System.out.println("执行时间：" + (endTime - startTime));
        Util.print(arr);
    }
}
