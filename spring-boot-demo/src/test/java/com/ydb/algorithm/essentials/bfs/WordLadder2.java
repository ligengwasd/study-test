package com.ydb.algorithm.essentials.bfs;

import java.util.*;

public class WordLadder2 {

    public static void main(String[] args) {
        WordLadder2 wordLadder2 = new WordLadder2();
        int i = wordLadder2.ladderLength(
                "hit",
                "dog",
                new HashSet<>(Arrays.asList("hot", "dot", "dog", "lot", "log"))
        );
        System.out.println(i);
    }

    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        Queue<WordNode> queue = new LinkedList<>();
        queue.add(new WordNode(beginWord, 1));

        while (!queue.isEmpty()) {
            WordNode topNode = queue.remove();
            if (endWord.equals(topNode.word)) {
                return topNode.numSteps;
            }
            char[] arr = topNode.word.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                for (char c = 'a'; c <= 'z'; c++) {
                    char tmp = arr[i];
                    if (tmp != c) {
                        arr[i] = c;
                    }
                    String newWord = new String(arr);
                    if (wordList.contains(newWord)) {
                        queue.add(new WordNode(newWord, topNode.numSteps+1));
                        wordList.remove(newWord);
                    }
                    arr[i] = tmp;
                }
            }
        }
        return 0;
    }

    class WordNode{
        String word;
        int numSteps;

        public WordNode(String word, int numSteps){
            this.word = word;
            this.numSteps = numSteps;
        }
    }
}
