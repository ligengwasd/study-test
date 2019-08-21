package com.ydb.algorithm.leetcode;

/**
 * Created by ligeng on 18/1/11.
 */
public class SearchInsert {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int val = 4;
        SearchInsert solution = new SearchInsert();
        System.out.println(solution.searchInsert(nums, val));

//        Solution solution = new Solution();
//        System.out.println(solution.searchInsert(nums,val));
    }

    //    https://blog.csdn.net/linhuanmars/article/details/20278967
    public int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (target == nums[mid]) return mid;
            if (target < nums[mid]) r = mid - 1;
            if (target > nums[mid]) l = mid + 1;
        }
        return l;
    }

    static class Solution {
        public int searchInsert(int[] nums, int target) {
            if (nums[0] > target) return 0;
            if (nums[nums.length - 1] < target) return nums.length;
            return searchInsertRecursion(nums, 0, nums.length - 1, target);
        }

        private int searchInsertRecursion(int[] nums, int left, int right, int target) {
            if (nums[left] == target) {
                return left;
            } else if (nums[right] == target) {
                return right;
            } else if (nums[left] < target && target < nums[right]) {
                if (right - left == 1) {
                    return left + 1;
                } else {
                    int mid = (left + right + 1) / 2;
                    if (target <= nums[mid]) {
                        return searchInsertRecursion(nums, left, mid, target);
                    } else {
                        return searchInsertRecursion(nums, mid, right, target);
                    }
                }
            } else {
                throw new RuntimeException();
            }
        }
    }
}

