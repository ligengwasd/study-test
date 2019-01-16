package com.ydb.algorithm.leetcode;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import java.util.*;

/**
 * @Author ligeng
 * @Date 19/1/16
 * @Time 下午7:19
 */
public class Q17_LetterCombinationsOfPhoneNumber {
    @Test
    public void test() {
        System.out.println((int) '1');
        List<String> strings = letterCombinations("02");
    }

    public List<String> letterCombinations(String digits) {
        LinkedList<String> ans = new LinkedList<String>();
        if(digits.isEmpty()) return ans;
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        for(int i =0; i<digits.length();i++){
            int x = Character.getNumericValue(digits.charAt(i));
            while(ans.peek().length()==i){
                String t = ans.remove();
                for(char s : mapping[x].toCharArray())
                    ans.add(t+s);
            }
        }
        return ans;
    }
}
