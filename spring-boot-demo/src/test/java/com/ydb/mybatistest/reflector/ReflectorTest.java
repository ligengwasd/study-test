package com.ydb.mybatistest.reflector;

import com.ydb.entity.mysql.SysData;
import org.apache.ibatis.reflection.DefaultReflectorFactory;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.ReflectorFactory;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.apache.ibatis.reflection.factory.ObjectFactory;
import org.apache.ibatis.reflection.wrapper.DefaultObjectWrapperFactory;
import org.apache.ibatis.reflection.wrapper.ObjectWrapperFactory;

/**
 * @Author ligeng
 * @Date 18/12/17
 * @Time 下午6:30
 */
public class ReflectorTest {
    public static void main(String[] args) throws Exception {
//        DefaultParameterHandler
        ReflectorFactory reflectorFactory = new DefaultReflectorFactory();
        ObjectFactory objectFactory = new DefaultObjectFactory();
        ObjectWrapperFactory objectWrapperFactory = new DefaultObjectWrapperFactory();

        MetaObject metaObject = MetaObject.forObject(new SysData(){{
            setName("111");
        }}, objectFactory, objectWrapperFactory, reflectorFactory);

        System.out.println(metaObject.getValue("name"));

    }
}
