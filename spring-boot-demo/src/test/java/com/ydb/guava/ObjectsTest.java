package com.ydb.guava;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.collect.ComparisonChain;
import com.google.common.collect.Ordering;
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

    @Test
    public void test2() {
        System.out.println(MoreObjects.toStringHelper(this).add("x", 1).toString());
    }

    @Test
    public void test3(){
    }

    public class Person implements Comparable<Person> {
        private String lastName;
        private String firstName;
        private int zipCode;

        public int compareTo(Person other) {
            return ComparisonChain.start()
                    .compare(this.zipCode, other.zipCode)
                    .result();
//            int cmp = lastName.compareTo(other.lastName);
//            if (cmp != 0) {
//                return cmp;
//            }
//            cmp = firstName.compareTo(other.firstName);
//            if (cmp != 0) {
//                return cmp;
//            }
//            return Integer.compare(zipCode, other.zipCode);
        }


    }



}
