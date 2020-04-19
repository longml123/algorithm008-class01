package com.qunar.qboss.qer.common.lianxi.stack;

import java.util.Stack;

/**
 * 判断是不是有效括号
 * //1、暴力求解，多次循环，时间复杂度n^2
 *  //2用栈
 */
public class Bracket {
    public static void main(String[] args) {
        String bracket = "(){}[]}";
        boolean valid = isValid(bracket);
        System.out.println(valid);
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            // 遇到左括号右括号进栈
            if(aChar == '('){
                stack.push(')');
            }else if (aChar == '{'){
                stack.push('}');
            }else if (aChar == '['){
                stack.push(']');
            }else {
                if (stack.empty()) return  false;

                // 遇到右括号且匹配，则出栈
                if (aChar == stack.peek()){
                    stack.pop();
                }else {
                    return false;
                }
            }
        }

        return stack.empty();
    }
}
