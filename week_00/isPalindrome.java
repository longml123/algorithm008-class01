package com.qunar.qboss.qer.common.lianxi.week00;

import org.apache.commons.lang.CharUtils;

/**
 * 125. 验证回文串
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 *
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 *
 * 输入: "race a car"
 * 输出: false
 * @author 18518
 */
public class isPalindrome {

    public static boolean isPalindrome01(String s) {
        StringBuffer sGood = new StringBuffer();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char sChar = s.charAt(i);
            if (CharUtils.isAsciiAlphanumeric(sChar)) {
                sGood.append(Character.toLowerCase(sChar));
            }
        }
        System.out.println(sGood);
        StringBuilder revGood = new StringBuilder(sGood).reverse();
        System.out.println(revGood);
        return sGood.toString().equals(revGood.toString());
    }

    public static void main(String[] args) {
        boolean palindrome = isPalindrome("1abbʼa1");
        System.out.println("返回结果：" + palindrome);

    }


    public static boolean isPalindrome02(String s) {
        StringBuffer sGood = new StringBuffer();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char sChar = s.charAt(i);
            if (CharUtils.isAsciiAlphanumeric(sChar)) {
                sGood.append(Character.toLowerCase(sChar));
            }
        }

        //是否是回文字符串
       return isPalindrome(sGood);

    }

    private static boolean isPalindrome(StringBuffer sGood) {
        System.out.println("验证字符串："+sGood);
        int length = sGood.length();
        int left = 0;
        int right = length -1 ;
        while (left < right) {
            if (Character.toLowerCase(sGood.charAt(left)) != Character.toLowerCase(sGood.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static boolean isPalindrome(String s) {
        if (s.isEmpty()) return true;

        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            while (left < right && !CharUtils.isAsciiAlphanumeric(s.charAt(left))) left++;
            while (left < right && !CharUtils.isAsciiAlphanumeric(s.charAt(right))) right--;

            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;

        }
        return true;
    }

    public static boolean isPalindrome04(String s) {
        String actual = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        String rev = new StringBuffer(actual).reverse().toString();
        return actual.equals(rev);
    }



}
