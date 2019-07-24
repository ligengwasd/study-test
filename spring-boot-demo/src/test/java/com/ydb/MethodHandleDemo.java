package com.ydb;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * @Author ligeng
 * @Date 19/7/24
 * @Time 下午3:10
 */
public class MethodHandleDemo {
    public static void main(String[] args) throws Throwable {
        Object obj = System.currentTimeMillis()%2 == 0 ? System.out : new ClassA();

        getPrintMH(obj).invokeExact("sssss");
    }

    private static MethodHandle getPrintMH(Object receiver) throws NoSuchMethodException, IllegalAccessException {
        MethodType methodType = MethodType.methodType(void.class, String.class);

        return MethodHandles.lookup().findVirtual(receiver.getClass(), "println", methodType).bindTo(receiver);
    }

    public static class ClassA{
        public void println(String s) {
            System.out.println(s);
        }
    }
}
