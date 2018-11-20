package com.ydb.distribuedNo;

/**
 * @Author ligeng
 * @Date 18/11/18
 * @Time 下午10:33
 */
public class Test {
    public static void main(String[] args) {
        DefaultKeyGenerator generator = new DefaultKeyGenerator();
        Long l = generator.generateKey().longValue();
        System.out.println(Long.toBinaryString(l));
//        Integer.toBinaryString()
    }
}
