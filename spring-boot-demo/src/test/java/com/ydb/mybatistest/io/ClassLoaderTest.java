package com.ydb.mybatistest.io;

import java.net.URL;

/**
 * @Author ligeng
 * @Date 18/12/22
 * @Time 下午11:59
 */
public class ClassLoaderTest {
    public static void main(String[] args) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
//        Class<Blog> loadClass = (Class<Blog>) classLoader.loadClass("com.ydb.mybatistest.pojo.Blog");
        URL url = classLoader.getResource("mybatis-config.xml");
//        Blog test = loadClass.newInstance();
        System.out.println(url);

    }
}
