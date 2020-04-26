package com.qunar.qboss.qer.common.lianxi;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = groupAnagrams(strs);
        for (List<String> list : lists) {
            System.out.println(list);
        }
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList<>();

        Map<String, List<String>> groupMap = new HashMap<>();
        for (String str : strs) {
            char[] strChars = str.toCharArray();
            Arrays.sort(strChars);
            String key = String.valueOf(strChars);
            if (!groupMap.containsKey(key)) groupMap.put(key,new ArrayList<>());
            groupMap.get(key).add(str);
        }
        return new ArrayList<>(groupMap.values());
    }
    public static List<List<String>> groupAnagrams1(String[] strs) {
        if (strs.length == 0)return new ArrayList<>();
        Map<String,List<String>> groupMap = new HashMap<>();
        int[] count = new int[26];
        for (String str : strs) {
            Arrays.fill(count,0);
            for (char c : str.toCharArray()) count[c - 'a']++;

            StringBuilder sb = new StringBuilder("");
            for (int i : count) {
                sb.append("#");
                sb.append(i);
            }
            String key = sb.toString();
            if (!groupMap.containsKey(key)) groupMap.put(key,new ArrayList<>());
            groupMap.get(key).add(str);

        }
        return new ArrayList<>(groupMap.values());
        
    }
}
