package com.ydb.algorithm.leetcode;

import org.junit.Test;

/**
 * @Author ligeng
 * @Date 19/1/20
 * @Time 下午2:08
 */
public class Q134_GasStation {
    @Test
    public void test() {
        canCompleteCircuit(new int[]{1,2,3,4,5},
                new int[]{3,4,5,1,2}
                );
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0;
        int total = 0;
        int start = -1;

        for(int i = 0; i < gas.length; i++){
            sum += gas[i] - cost[i];
            total += gas[i] - cost[i];

            if(sum < 0){
                start = i;
                sum = 0;
            }
        }

        if(total < 0){
            return -1;
        }else{
            return start + 1;
        }
    }
}
