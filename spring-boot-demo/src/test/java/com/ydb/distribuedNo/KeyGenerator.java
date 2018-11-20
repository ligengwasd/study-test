package com.ydb.distribuedNo;

/**
 * @Author ligeng
 * @Date 18/11/18
 * @Time 下午10:32
 */
public interface KeyGenerator {
    /**
     * 生成主键.
     *
     * @return 自动生成的主键
     */
    Number generateKey();
}
