package com.ydb.algorithm.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 非递归解法
 *
 * @Author ligeng
 * @Date 19/1/15
 * @Time 下午9:12
 */
public class Q46_Permutations_2 {
    @Test
    public void test() {
        permute(new int[] {1,2,3});
    }

    public List<List<Integer>> permute(int[] nums) {

        core(nums);
        return null;
    }

    private  void core(int[] array) {
        // 先排序
        Arrays.sort(array);
        System.out.println(Arrays.toString(array)); // 最初始的序列
        do {
            nextArray(array);
            System.out.println(Arrays.toString(array));
        } while (!isLast(array));
    }

    private  int[] nextArray(int[] array) {
        int length = array.length;
        // 寻找替换点
        int cursor = 0;
        for (int i = length - 1; i >= 1; i--) {
            // 找到第一个递增的元素对
            if (array[i - 1] < array[i]) {
                cursor = i - 1; // 找到替换点
                break;
            }
        }

        // 寻找在替换点后面的次小元素
        int biggerCursor = cursor + 1;
        for (int i = cursor + 1; i < length; i++) {
            if (array[cursor] < array[i] && array[i] < array[biggerCursor]) {
                biggerCursor = i;
            }
        }

        // 交换
        swap(array, cursor, biggerCursor);

        // 对替换点之后的序列进行反转
        reverse(array, cursor);

        return array;
    }

    private  void reverse(int[] array, int cursor) {
        int end = array.length - 1;
        for (int i = cursor + 1; i <= end; i++, end--) {
            swap(array, i, end);
        }
    }

    private  boolean isLast(int[] array) {
        int length = array.length;
        for (int i = 1; i < length; i++) {
            if (array[i - 1] < array[i]) {
                return false;
            }
        }
        return true;
    }

    public void swap(int s[], int i, int j) {
        int temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }


//    作者：Q-WHai
//    来源：CSDN
//    原文：https://blog.csdn.net/lemon_tree12138/article/details/50986990
//    版权声明：本文为博主原创文章，转载请附上博文链接！


}
