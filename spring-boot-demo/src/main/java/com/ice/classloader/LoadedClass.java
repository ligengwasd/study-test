package com.ice.classloader;

/**
 * @Author ligeng
 * @Date 19/5/4
 * @Time 下午4:48
 */
public class LoadedClass {
    public LoadedClass() {
        System.out.println("LoadedClass is loaded by: "
                + this.getClass().getClassLoader());

    }
}
