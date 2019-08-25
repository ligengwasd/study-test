package com.ydb.jdk8.demo.defalutinterface;

/**
 * @Author ligeng
 * @Date 19/8/25
 * @Time 下午3:03
 */
public class InterfaceDemoImpl implements InterfaceDemo {
//    public boolean isEmpty() {
//        return true;
//    }

    public static void main(String[] args) {
        InterfaceDemoImpl demo = new InterfaceDemoImpl();
        System.out.println(demo.isEmpty());
    }
}
