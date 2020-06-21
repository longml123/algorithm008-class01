package com.qunar.qboss.qer.common.lianxi.week09;

public class ToLowerCase {

    public static String toLowerCase(String str) {
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) < 65 || str.charAt(i) > 90) {
                result.append(str.charAt(i));
            }else {
                result.append((char)((int)(str.charAt(i)) + 32));
            }
        }
        return result.toString();
    }

    public static String toLowwerCase(String str){
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] >= 'A' && charArray[i] <= 'Z') {
                charArray[i] += 32;
            }
        }
        return String.valueOf(charArray);
    }
}
