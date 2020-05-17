package com.qunar.qboss.qer.common.lianxi.week04;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    public static void main(String[] args) {

    }

    public List<String> generateParenthesis(int n){
        List<String> resultList = new ArrayList<>();
        if (n == 0) {
            return  resultList;
        }
        dfs("",n,n,resultList);
        return  resultList;
    }

    private void dfs(String curr, int left, int right, List<String> resultList) {
        if (left == 0 && right == 0) {
            resultList.add(curr);
            return;
        }
        if (right < left) {
            return;
        }

        if (left > 0) {
            dfs(curr + "(",left - 1, right, resultList);
        }

        if (right >= left) {
            dfs(curr + ")", left, right -1,resultList);
        }
    }

    public List<String> generateParenthesis01(int n){
        List<String> resultList = new ArrayList<>();
        if (n == 0) {
            return  resultList;
        }
        dfs01("",0,0, n,resultList);
        return  resultList;
    }

    private void dfs01(String curr, int left, int right,int n, List<String> resultList) {
        if (left == n && right == n) {
            resultList.add(curr);
            return;
        }

        if (right > left) {
            return;
        }

        if (left < n) {
            dfs01(curr + "(",left + 1, right, n,resultList);
        }
        if (right < n) {
            dfs01(curr + ")",left, right + 1,n,resultList);
        }
    }


}
