package com.qunar.qboss.qer.common.lianxi.week07;

import java.util.Arrays;

public class FindCircleNum {

    public int find(int[] parent,int i){
        if (parent[i] == -1) {
            return i;
        }

        return find(parent,parent[i]);
    }

    public void union(int[] parent,int x, int y){
        int rootx = find(parent,x);
        int rooty = find(parent,y);
        if (rootx != rooty) {
            parent[rootx] = rooty;
        }
    }

    public int findCircleNum(int[][] m){
        int[] parent = new int[m.length];
        Arrays.fill(parent,-1);
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length ; j++) {
                if (m[i][j] == 1 && i != j) {
                    union(parent,i,j);
                }
            }
        }

        int count = 0;
        for (int i = 0; i < parent.length; i++) {
            if (parent[i] == -1) {
                count++;
            }
        }
        return count;
    }
}
