package com.ydb.algorithm.essentials.binarytree.search;

/**
 * @Author ligeng
 * @Date 19/8/21
 * @Time 上午10:19
 */
public class KthLargestElementArray {
    public static void main(String[] args) {
        KthLargestElementArray solution = new KthLargestElementArray();
        int[] ints = {3,2,1,5,6,4};
        int k=2;
        int array = solution.findKthLargest(ints, k);
        System.out.println(array);
    }

//    堆排序，维护一个k大小的小根堆，将数组中的每个元素与堆顶元素进行比较，如果比堆顶元素大，
// 则删除堆顶元素并添加该元素，如果比堆顶元素小，则什么也不做，继续下一个元素。时间复杂度O(nlogk)，空间复杂度O(k)。
//    public int findKthLargest(int[] nums, int k) {
//        PriorityQueue<Integer> queue = new PriorityQueue<>();
//        for (int val:nums) {
//            queue.offer(val);
//            if (queue.size() > k) {
//                // 根节点是最小的，把最小的节点弹出去。
//                queue.poll();
//            }
//        }
//        return queue.peek();
//    }

    public int findKthLargest(int[] nums, int k) {
        return findKthLargest222(nums, 0, nums.length-1, k);
    }

//  思路：  https://www.cnblogs.com/grandyang/p/4539757.html
    private int findKthLargest222(int[] nums, int begin, int end, int k) {
        int pos = partition(nums, begin, end);
        if (pos==k-1) {
            return nums[pos];
        } else if (pos<k-1) {
            return findKthLargest222(nums, pos+1, end, k);
        } else {
            return findKthLargest222(nums, begin, pos-1, k);
        }
    }

    private static int partition(int[] nums, int i, int j) {
        int pivot = nums[i];
        while (i<j) {
            while (i<j && nums[j] <= pivot) j--;
            nums[i] = nums[j];
            while (i<j && nums[i] >= pivot) i++;
            nums[j] = nums[i];
        }
        nums[i] = pivot;
        return i;
    }

}
