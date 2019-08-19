package com.ydb.algorithm.leetcode;

import java.util.*;

/**
 * @Author ligeng
 * @Date 19/8/19
 * @Time 上午10:42
 */
public class WorldLaader {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);

        if (set.contains(endWord)) return 0;

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
                }
                String newWord = newWordArray.toString();
                if (set.contains(newWord) && newWord.equals(endWord)) {
                    return map.get(word)+1;
                }
                if (set.contains(newWord) && !map.containsKey(newWord)) {
                    queue.offer(newWord);
                    map.put(newWord, map.get(word)+1);
                }
            }
        }
        return 0;
    }

}
