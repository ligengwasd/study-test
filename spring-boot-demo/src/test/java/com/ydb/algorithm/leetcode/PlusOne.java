package com.ydb.algorithm.leetcode;

/**
 * Created by ligeng on 18/1/11.
 */
public class PlusOne {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] s = solution.plusOne(new int[]{1,2,9});
        System.out.println(s);
    }

    static class Solution {
        public int[] plusOne(int[] digits) {
            int c=0;
            for(int i=digits.length-1;i>=0;i--){
                digits[i]++;
                c=digits[i]/10;
                if(c==0)
                    break;
                digits[i]%=10;
            }
            System.out.println("c:"+c);
            if(c==0)
                return digits;
            int[] newdigits=new int[digits.length+1];
            newdigits[0]=1;
            for(int i=0;i<digits.length;i++)
                newdigits[i+1]=digits[i];
            return newdigits;

        }
    }
}
