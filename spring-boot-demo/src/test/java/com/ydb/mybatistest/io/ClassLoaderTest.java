package com.ydb.mybatistest.io;

import com.ydb.mybatistest.pojo.Blog;
import lombok.Data;
import org.apache.ibatis.io.ResolverUtil;
import org.apache.ibatis.io.VFS;
import org.junit.Test;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import java.util.List;
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

    @Test
    public void testResolverUtil2() {
        ResolverUtil<Blog> resolverUtil = new ResolverUtil<>();
        resolverUtil.findAnnotated(RestController.class, "com.ydb.controller");
        Set<Class<? extends Blog>> classes = resolverUtil.getClasses();
        System.out.println(classes);
    }

    @Test
    public void testVFS() throws IOException {
        VFS vfs = VFS.getInstance();
        List<String> list = vfs.list("com.ydb.mybatistest.pojo");
        System.out.println(list);
    }
}
