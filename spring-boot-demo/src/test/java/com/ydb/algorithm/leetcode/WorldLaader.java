package com.ydb.algorithm.leetcode;

import com.alibaba.druid.sql.visitor.functions.Char;

import java.util.*;

/**
 * @Author ligeng
 * @Date 19/8/19
 * @Time 上午10:42
 */
public class WorldLaader {
    public static void main(String[] args) {
        WorldLaader demo = new WorldLaader();
        System.out.println(new String(new char[]{'a', 'b'}) );
        System.out.println(demo.ladderLength("hit", "cog",Arrays.asList("hot","dot","dog","lot","log","cog")));
    }

    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int res=0;

        while (!queue.isEmpty()) {
            int k = queue.size();
            for (int j=0; j<k; j++) {

            }
        }
        return res;

    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);

        Map<String, Integer> map = new HashMap<>();
        map.put(beginWord, 1);

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        while (!queue.isEmpty()) {
            String word = queue.poll();
            for (int i = 0; i < word.length(); ++i) {
                char[] newWordArray = word.toCharArray();
                for (char ch = 'a'; ch <= 'z'; ++ch) {
                    newWordArray[i] = ch;
                    String newWord = new String(newWordArray) ;
                    if (set.contains(newWord) && newWord.equals(endWord)) {
                        return map.get(word)+1;
                    }
                    if (set.contains(newWord) && !map.containsKey(newWord)) {
                        queue.offer(newWord);
                        map.put(newWord, map.get(word)+1);
                    }
                }
            }
        }
        return 0;
    }

}
