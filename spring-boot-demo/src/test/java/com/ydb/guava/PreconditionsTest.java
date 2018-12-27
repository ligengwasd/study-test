package com.ydb.guava;

import static com.google.common.base.Preconditions.*;
import org.junit.Test;

/**
 * @Author ligeng
 * @Date 18/12/27
 * @Time 下午3:22
 */
public class PreconditionsTest {
    @Test
    public void test1() {
        checkNotNull(null, "ssss %s", "111");

    }
}
