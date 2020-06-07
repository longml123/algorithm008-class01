package com.qunar.qboss.qer.common.lianxi.week07;

/**
 * 并查集
 * @author 18518
 */
public class UnionFind {
    int count;
    int[] parent;
    int[] rank;

    public UnionFind(char[][] grad) {
        count = 0;
        int m = grad.length;
        int n = grad[0].length;
        parent = new int[m * n];
        rank = new int[m * n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grad[i][j] == '1') {
                    parent[i * n + j] = i * n + j;
                    ++count;
                }
                rank[i * n + j] = 0;
            }
        }
    }

    public int find(int i){
        if (parent[i] != i) {
            parent[i] = find(parent[i]);
        }
        return parent[i];
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            }else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            }else {
                parent[rootY] = rootX;
                rank[rootX] += 1;
            }
            --count;
        }
    }

    public int getCount() {
        return count;
    }
}
