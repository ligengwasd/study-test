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

    // 暴力枚举法
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

    // 优化思路
    // 假设电梯停在第i层，显然我们可以计算出所有乘客总共要爬楼梯的层数Y。如果有N1个乘客目的楼层在第i层楼一下，有N2个乘客在第i层楼，还有N3个乘客在第i层以上。
    // 这个时候，如果电梯改停在第i-1层，所有目的地在第i-1层一下的蹭课可以少爬一层，总共可以少爬N1层，所有目的地在i层及以上的乘客都需要多爬1层，总共需要多爬N2+N3层。
    // 因此，乘客总共需要爬的层数为Y-N1+（N2+N3）=Y-（N1-N2-N3）层。
    // 反之，如果电梯在i+1层停那么乘客总共需要爬的层数为Y+（N1+N2-N3）层。由此可见，当N1>N2+N3时，电梯在第i-1层停更好，乘客走的楼层数减少N1-N2-N3层；
    public int cal2(int[] nPerson) {

        // i=1时：
        int N1=nPerson[0], N2=nPerson[1], N3=0;
        for (int i=2; i<nPerson.length; i++) {
            N3 += nPerson[i];
        }
        // TODO: 19/8/20  



        return 0;
    }
}
