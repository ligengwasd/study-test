package com.ydb.algorithm.leetcode;

/**
 * Created by ligeng on 18/1/11.
 */
public class SearchInsert {
    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int val = 4;
        SearchInsert solution = new SearchInsert();
        System.out.println(solution.searchInsert(nums, val));

//        Solution solution = new Solution();
//        System.out.println(solution.searchInsert(nums,val));
    }

    public int searchInsert(int[] nums, int target) {
        return search(nums, 0, nums.length-1, target);
    }

    private int search(int[] nums, int first, int last, int target) {
        while (first<last) {
            int mid = first + (last-first)/2;
            if (target < nums[mid]) {
                last = mid;
            } else {
                first = mid+1;
            }
        }
        return first;
    }


    static class Solution {
        public int searchInsert(int[] nums, int target) {
            if (nums[0] > target) return 0;
            if (nums[nums.length-1] < target) return nums.length;
            return searchInsertRecursion(nums,0,nums.length-1,target);
        }

        private int searchInsertRecursion(int[] nums,int left,int right,int target){
            if (nums[left] == target) {
                return left;
            } else if (nums[right] == target){
                return right;
            } else if (nums[left] < target && target < nums[right]){
                if (right - left == 1) {
                    return left+1;
                } else {
                    int mid = (left+right+1)/2;
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

