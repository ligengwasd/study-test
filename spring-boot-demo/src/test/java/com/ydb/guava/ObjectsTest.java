package com.ydb.guava;

import com.google.common.base.Objects;
import org.junit.Test;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * @Author ligeng
 * @Date 18/12/27
 * @Time 下午3:33
 */
public class ObjectsTest {
    @Test
    public void test1() {
        Objects.equal("a", "a"); // returns true
        Objects.equal(null, "a"); // returns false
        Objects.equal("a", null); // returns false
        Objects.equal(null, null);// returns true


        System.out.println(Objects.hashCode("1","2"));
    }
}
