package com.ydb.algorithm.leetcode;

/**
 * https://leetcode.com/problems/maximum-subarray/description/
 * https://my.oschina.net/itblog/blog/267860
 * @Author ligeng
 * @Date 18/8/29
 * @Time 上午12:13
 */
public class Q53_MaxSubArray {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }

    /**
     * 最直观的解法，两个指针之间即为子序列，算出所有子序列的值。
     * @param nums
     * @return
     */
    public static int solution3(int[] nums){
        int maxNum=Integer.MIN_VALUE;
        for (int i=0; i<nums.length; i++) {
            for (int j=i; j<nums.length; j++) {
                // 算出 i到j的 和
                int thisNum = 0;
                for (int k=i; k<=j; k++) {
                    thisNum += nums[k];
                }
                if (thisNum > maxNum) maxNum = thisNum;
            }
        }
        return maxNum;
    }


    /**
     * 最优解：
     * maxEndingHere表示以第n个节点结尾的和最大的子序列，x表示第n+1个节点，
     * 所以以第n+1个节点结尾的和最大的子序列有两种可能：
     *  1、不包含节点n，那么该子序列就只有x一个元素
     *  2、包含几点n，那么该子序列的和为 maxEndingHere+x
     * 所以以第n+1个节点结尾的和最大的子序列的和为Math.max(num+maxEndingHere, num);
     * 参考：https://zh.wikipedia.org/wiki/%E6%9C%80%E5%A4%A7%E5%AD%90%E6%95%B0%E5%88%97%E9%97%AE%E9%A2%98
     * @param nums
     * @return
     */
    public static int solution(int[] nums) {
        int maxSoFar = Integer.MIN_VALUE, maxEndingHere=0;
        for (int num : nums) {
            maxEndingHere = Math.max(num+maxEndingHere, num);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }

    /**
     * 最优解
     * 参见：https://blog.csdn.net/joylnwang/article/details/6859677
     * @param nums
     * @return
     */
    public static int solution4(int[] nums) {
        int thisSum = nums[0], sum=nums[0];
        for (int i=1; i<nums.length; i++) {
            if (thisSum < 0) {
                thisSum = 0;
            }
            thisSum += nums[i];
            sum = Math.max(thisSum, sum);
        }
        return sum;
    }

    /**
     * 因为最大连续子序列和只可能从数组0到n-1中某个位置开始，我们可以遍历0到n-1个位置，计算由这个位置开始的所有连续子序列和中的最大值。最终求出最大值即可。
     * 更详细的讲，就是计算从位置0开始的最大连续子序列和，从位置1开始的最大连续子序列和。。。直到从位置n-1开始的最大连续子序列和，最后求出所有这些连续子序列和中的最大值就是答案。
     * @param nums
     * @return
     */
    public static int solution2(int[] nums) {
        int max = nums[0]; //初始化最大值为第一个元素
        for (int i=0; i<nums.length; i++) {
            int sum = 0; //sum必须清零
            for (int j=i; j<nums.length; j++) { //从位置i开始计算从i开始的最大连续子序列和的大小，如果大于max，则更新max。
                sum += nums[j];
                if (sum > max)
                    max = sum;
            }
        }
        return max;
    }
}
