package com.ydb.mybatistest.io;

import com.ydb.mybatistest.pojo.Blog;
import org.apache.ibatis.io.ResolverUtil;
import org.junit.Test;

import java.io.Serializable;
import java.net.URL;
import java.util.Set;

/**
 * @Author ligeng
 * @Date 18/12/22
 * @Time 下午11:59
 */
public class ClassLoaderTest {
    @Test
    public void testClassLoader() {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
//        Class<Blog> loadClass = (Class<Blog>) classLoader.loadClass("com.ydb.mybatistest.pojo.Blog");
        URL url = classLoader.getResource("mybatis-config.xml");
//        Blog test = loadClass.newInstance();
        System.out.println(url);
    }

    @Test
    public void testResolverUtil() {
        ResolverUtil<Blog> resolverUtil = new ResolverUtil<>();
        resolverUtil.findImplementations(Serializable.class, "com.ydb.mybatistest.pojo");
        Set<Class<? extends Blog>> classes = resolverUtil.getClasses();
        System.out.println(1);
    }
}
