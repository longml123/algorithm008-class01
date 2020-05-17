package com.qunar.qboss.qer.common.lianxi.week04;

import java.util.*;

/**
 * 127. 单词接龙
 * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
 *
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * 说明:
 *
 * 如果不存在这样的转换序列，返回 0。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 * 示例 1:
 *
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 *
 * 输出: 5
 *
 * 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 *      返回它的长度 5。
 * 示例 2:
 *
 * 输入:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 *
 * 输出: 0
 *
 * 解释: endWord "cog" 不在字典中，所以无法进行转换。
 */
public class LadderLength {
    public static void main(String[] args) {
        String beginWord = "hit";
        String  endWord = "cog";
        String[] strArray = {"hot","dot","dog","lot","log","cog"};
        List<String> wordList =  new ArrayList<String>(Arrays.asList(strArray));
        int i = ladderLength(beginWord, endWord, wordList);
        System.out.println("转换次数" + i);

    }
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, Set<String>> graph = constructGraph(beginWord, wordList);
        //队列
        Queue<String> queue = new LinkedList<>();
        //记录已经访问过的元素
        Set<String> visit = new HashSet<>();
        queue.add(beginWord);
        visit.add(beginWord);
        int result = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            //每一次循环代表宽度增1
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                Set<String> neighbors = graph.get(curr);
                for (String neighbor : neighbors) {
                    if (neighbor == endWord) return  result + 1;
                    //还没加入
                    if (!visit.contains(neighbor)) {
                        queue.add(neighbor);
                        visit.add(neighbor);
                    }
                }
            }
            //遍历一层则+1
            result++;
        }
        return  0;
    }

    /**
     * 判断两个单词是否仅一个字母不同
     * @param word1
     * @param word2
     * @return
     */
    public static boolean connect(String word1, String word2){
        int diff = 0;
        for (int i = 0; i <word1.length() ; i++) {
            if (word1.charAt(i) != word2.charAt(i)) diff++;
        }
        return diff == 1;
    }

    /**
     * //构建图,graph必须为引用
     * @param word
     * @param wordList
     * @return
     */
    public static Map<String, Set<String >> constructGraph(String word, List<String> wordList) {
        Map<String, Set<String >>  graph = new HashMap<>();
        wordList.add(word);
        for (int i = 0; i < wordList.size(); i++) {
            graph.put(wordList.get(i),new HashSet<String>());
            for (int j = 0 ; j < wordList.size(); j++) {
                if (connect(wordList.get(i),wordList.get(j))){
                    graph.get(wordList.get(i)).add(wordList.get(j));
                }
            }
        }
        return graph;
    }


}
