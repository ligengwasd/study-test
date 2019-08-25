package com.ydb.jdk8.demo.defalutinterface;

/**
 * @Author ligeng
 * @Date 19/8/25
 * @Time 下午3:02
 */
public interface InterfaceDemo {
    default boolean isEmpty() {
        return false;
    }
}
