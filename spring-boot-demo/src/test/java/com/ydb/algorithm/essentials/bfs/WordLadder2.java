package com.ydb.algorithm.essentials.bfs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordLadder2 {

    public static void main(String[] args) {
        WordLadder2 wordLadder2 = new WordLadder2();
        int i = wordLadder2.ladderLength(
                "hit",
                "dog",
                Arrays.asList("hot", "dot", "dog", "lot", "log")
        );
        System.out.println(i);
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<String>(wordList);

        // 边界情况判断
        // 字符串数组里如果没有目标字符串，那么返回0，也就是永远也不可能变形成功
        if( !wordSet.contains(endWord) )
            return 0;


        // 出发字符串 和 目标字符串 在字符串数组 你一下我一下 轮着进行 变形
        Set<String> forwardSet = new HashSet<String>();
        Set<String> backwardSet = new HashSet<String>();

        forwardSet.add(beginWord);
        backwardSet.add(endWord);

        wordSet.remove(endWord);
        wordSet.remove(beginWord);

        return transform(forwardSet, backwardSet, wordSet);
    }

    public int transform(Set<String> forwardSet, Set<String> backwardSet, Set<String> wordSet) {
        Set<String> newSet = new HashSet<String>();

        // 循环 出发字符串数组中的每个字符串
        for(String fs : forwardSet) {
            char wordArray[] = fs.toCharArray();

            // 循环 出发字符串的每个字符
            for(int i = 0; i < wordArray.length; i++) {

                //将每个字符 从'a' 到 'z' 挨个变换一下
                for(int c = 'a'; c <= 'z'; c++) {
                    char origin = wordArray[i];
                    wordArray[i] = (char) c;
                    String target = String.valueOf(wordArray);

                    // 如果和目标字符串一样了
                    if( backwardSet.contains(target) )
                        return 2;
                        // 如果变形后的字符串 在字符串数组里有，且没有和变形前的字符串们重复，那么添加到set
                    else if( wordSet.contains(target) && !forwardSet.contains(target) ) {
                        wordSet.remove(target);
                        newSet.add(target);
                    }
                    // 退回到之前的字母，方便for循环下一个变形字符串
                    wordArray[i] = origin;
                }
            }
        }

        if( newSet.size() == 0 )
            return 0;

        forwardSet = newSet;

        // 如果上一步是 出发字符串变形的，那么下一步轮到 目标字符串 变形了。
        // 让 出发字符串 和 目标字符串 轮着 变形
        int result = forwardSet.size() > backwardSet.size() ?
                transform(backwardSet, forwardSet, wordSet) : transform(forwardSet, backwardSet, wordSet);

        return result == 0 ? 0 : result + 1;
    }
}
