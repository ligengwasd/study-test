package com.ydb.algorithm.leetcode;

/**
 * @Author ligeng
 * @Date 18/9/1
 * @Time 上午9:58
 */
public class Q13_RomanToInt {
    public int solution(String s) {
        int sum=0;
        char[] array = s.toCharArray();

        if(s.indexOf("IV")!=-1){sum-=2;}
        if(s.indexOf("IX")!=-1){sum-=2;}
        if(s.indexOf("XL")!=-1){sum-=20;}
        if(s.indexOf("XC")!=-1){sum-=20;}
        if(s.indexOf("CD")!=-1){sum-=200;}
        if(s.indexOf("CM")!=-1){sum-=200;}

        for (int i=0; i<array.length; i++) {
            if(array[i]=='M') sum+=1000;
            if(array[i]=='D') sum+=500;
            if(array[i]=='C') sum+=100;
            if(array[i]=='L') sum+=50;
            if(array[i]=='X') sum+=10;
            if(array[i]=='V') sum+=5;
            if(array[i]=='I') sum+=1;
        }

        return sum;
    }
}
