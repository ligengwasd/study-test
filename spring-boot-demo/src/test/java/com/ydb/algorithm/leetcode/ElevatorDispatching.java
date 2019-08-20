package com.ydb.algorithm.leetcode;

/**
 * 电梯调度问题
 * https://blog.csdn.net/buyoufa/article/details/52269175
 * @Author ligeng
 * @Date 19/8/20
 * @Time 下午10:01
 */
public class ElevatorDispatching {
    public static void main(String[] args) {
        ElevatorDispatching solution = new ElevatorDispatching();
    }

    public int cal(int[] nPerson) {
        int minSum=0;
        for (int i=0; i<nPerson.length; i++) {
            int curSum=0;
            for (int j=0; j<nPerson.length; j++) {
                curSum += nPerson[i]*Math.abs(j-i);
            }
            minSum = Math.min(minSum, curSum);
        }
        return minSum;
    }
}
