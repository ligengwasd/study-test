package com.ydb.algorithm;

import org.apache.commons.lang.math.RandomUtils;

/**
 * Created by ligeng on 18/1/7.
 */
public class elevator {
    private static int n = 9;//这个表示电梯所在的最高楼层
    private static int nPerson[] = new int[]{1,5,10,6,7,9,8,2,3,4};//这个数组表示要去每一层的乘客数
    public static void main(String[] args) {
        test1();
    }

    public static void test1(){
        //上面的两个变量应该是给出的，这里只是示意代码没有初始化。
        int nFloor,nMinFloor=-1,nTargetFloor;//分别表示电梯停在第n层时候的结果，目前为止的最小结果，最小结果所停的楼层。
        nTargetFloor = -1;//考虑到初始化最小结果和最小结果所砸的楼层，所以先设定为一个非法值
        //循环遍历每个楼层的结果，算出本层的结果，如果比之前结果小，就替换之前结果
        for(int i = 1; i <= n; i++){
            nFloor = 0;
            //计算本层以下的楼层的人的总消耗
            for(int j =1; j < i; j++){
                nFloor += nPerson[j]*(i-j);
            }
            //计算本层以上的楼层的人的总消耗
            for(int j = i+1; j <= n; j++){
                nFloor += nPerson[j]*(j - i);
            }
            //如果比之前结果小，或者还没初始化，就用本层结果替换之前结果。
            if(nMinFloor == -1 || nMinFloor > nFloor){
                nMinFloor = nFloor;
                nTargetFloor = i ;
            }

            System.out.println(i +"，"+nFloor+"，"+nMinFloor+"，"+nTargetFloor);
        }
    }
}
