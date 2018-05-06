package com.ydb.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * 模拟堆溢出
 * -Xmx10m -Xms10m -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/tmp/HeapOOM_DUMP
 */
public class HeapOOM {
    static class OOMObject{

    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while (true) {
            list.add(new OOMObject());
        }
    }
    
}
