package com.ydb.algorithm.leetcode;

/**
 * @Author ligeng
 * @Date 19/8/23
 * @Time 上午11:33
 */
public class SearchRotatedSortedArray {
    public static void main(String[] args) {
        SearchRotatedSortedArray solution = new SearchRotatedSortedArray();

    }

    public int search(int[] nums, int target) {
        int first = 0, last = nums.length;
        while (first != last) {
            final int mid = first + (last - first) / 2;
            if (nums[mid] == target)
                return mid;
            if (nums[first] <= nums[mid]) {
                if (nums[first] <= target && target < nums[mid])
                    last = mid;
                else
                    first = mid + 1;
            } else {
                if (nums[mid] < target && target <= nums[last - 1])
                    first = mid + 1;
                else
                    last = mid;
            }
        }
        return -1;
    }


}
