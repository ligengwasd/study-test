package com.ydb.jdk8;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author ligeng
 * @Date 18/7/31
 * @Time 上午9:55
 */
public class Demo {
    public static void main(String[] args) {
        List list = new ArrayList();
        new File(".").listFiles(File::isHidden);
    }
}
