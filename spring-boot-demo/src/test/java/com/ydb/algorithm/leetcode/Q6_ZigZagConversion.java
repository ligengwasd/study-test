package com.ydb.algorithm.leetcode;

import org.junit.Test;

/**
 * @Author ligeng
 * @Date 19/1/11
 * @Time 下午5:35
 */
public class Q6_ZigZagConversion {
    @Test
    public void test() {
        System.out.println(convert("PAYPALISHIRING",2));
    }

    public String convert(String s, int numRows) {
        char[] chars = s.toCharArray();
        StringBuffer[] sb = new StringBuffer[numRows];
        for (int i=0; i<numRows; i++) {
            sb[i] = new StringBuffer();
        }

        int i=0;
        while (i<chars.length) {
            for (int idx=0; idx<numRows && i<chars.length; idx++) {
                sb[idx].append(chars[i++]);
            }
            for (int idx=numRows-2; (idx>=1)&&(i<chars.length); idx--) {
                sb[idx].append(chars[i++]);
            }
        }

        String res = "";
        for (StringBuffer item:sb) {
            res +=item.toString();
        }
        return res;

    }
}
