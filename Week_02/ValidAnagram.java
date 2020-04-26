package com.qunar.qboss.qer.common.lianxi;

import java.util.Arrays;

public class ValidAnagram {
    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        boolean anagram = isAnagram01(s, t);
        System.out.println(anagram);
    }

    /**
     *
     * 排序,对比
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        Arrays.sort(sChars);
        Arrays.sort(tChars);
        return  Arrays.equals(sChars,tChars);
    }

    /**
     *
     * 排序,对比
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram01(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] ints = new int[26];
        for (int i = 0; i < s.length(); i++) {
            ints[s.charAt(i) - 'a']++;
            ints[t.charAt(i) - 'a']--;
        }
        for (int anInt : ints) {
            if (anInt !=0){
                return false;
            }
        }
        return  true;
    }
}
