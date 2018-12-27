package com.ydb.guava;

import com.google.common.base.Enums;
import org.junit.Test;

/**
 * @Author ligeng
 * @Date 18/12/27
 * @Time 下午4:56
 */
public class EnumsTest {
    @Test
    public void test1() {
        System.out.println(Enums.getIfPresent(TestEnum.class, "CHEETO1"));
    }

    private enum TestEnum {
        CHEETO,
        HONDA,
        POODLE,
    }
}
