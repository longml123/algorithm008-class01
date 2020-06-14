package com.qunar.qboss.qer.common.lianxi.week08;

import java.util.Arrays;

public class Anagram {


    public static boolean isAnagram(String s, String t){
        if (s.length() != t.length()) return false;

        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        Arrays.sort(sChars);
        Arrays.sort(tChars);

        for (int i = 0; i < s.length(); i++) {
            if (sChars[i] != tChars[i]) return false;
        }

       return true;
    }

    public static void main(String[] args) {
        boolean anagram = isAnagram("anagram", "nagaram");
        System.out.println("\"anagram\", \"nagaram\" :" + anagram);

    }

    public static boolean isAnagram01(String s, String t){
        char[] countNum = new char[26];

        for (char sChar : s.toCharArray()) {
            countNum[sChar - 'a']++;
        }

        for (char tChar : t.toCharArray()) {
            countNum[tChar - 'a']--;
        }

        for (int i = 0; i < countNum.length; i++) {
            if (countNum[i] != 0) return false;
        }

        return true;
    }
}
