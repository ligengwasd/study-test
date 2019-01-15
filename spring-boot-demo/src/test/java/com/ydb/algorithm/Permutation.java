package com.ydb.algorithm;

import com.ydb.sort.Util;
import org.junit.Test;

import java.util.Random;

/**
 * @Author ligeng
 * @Date 19/1/14
 * @Time 下午5:40
 */
public class Permutation {

    public void permutation(char[]ss,int i){
        if(ss==null||i<0 ||i>ss.length){//1
            return;
        }

        if(i==ss.length-1){//2
            System.out.println(new String(ss));
        }else{
            for(int j=i;j<ss.length;j++){//3
                char temp=ss[j];//交换前缀,使之产生下一个前缀
                ss[j]=ss[i];
                ss[i]=temp;
                permutation(ss,i+1);//4
                temp=ss[j]; //将前缀换回来,继续做上一个的前缀排列.//5
                ss[j]=ss[i];
                ss[i]=temp;
            }
        }
    }

    @Test
    public void test() {
        int[] array = new int[]{1,2,3};
        int length = array.length;
        fullArray(array, 0, length - 1);
    }

    private static void fullArray(int[] array, int cursor, int end) {
        if (cursor == end) {
            Util.print(array);
        } else {
            for (int i = cursor; i <= end; i++) {
                Util.swap(array, cursor, i);
                fullArray(array, cursor + 1, end);
                Util.swap(array, cursor, i);
            }
        }
    }
}
