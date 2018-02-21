package com.ydb.algorithm.leetcode;

/**
 * Created by ligeng on 18/2/21.
 */
public class SingleNumber {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] a = {2,1,4,5,2,4,1};
        System.out.println(solution.singleNumber(a));
    }

//    因为A XOR A = 0，且XOR运算是可交换的，于是，对于实例{2,1,4,5,2,4,1}就会有这样的结果：
//            (2^1^4^5^2^4^1) => ((2^2)^(1^1)^(4^4)^(5)) => (0^0^0^5) => 5
//    就把只出现了一次的元素(其余元素均出现两次)给找出来了！
    static class Solution {
        public int singleNumber(int[] nums) {
            int result = 0;
            for(int i : nums) {
                result ^= i;
            }
            return result;
        }
    }
}
