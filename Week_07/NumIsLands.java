package com.qunar.qboss.qer.common.lianxi.week07;

/**
 * 200. 岛屿数量
 * @author 18518
 */
public class NumIsLands {

    public static int numIslands(char[][] grid){
        if (grid == null || grid.length ==0) {
            return 0;
        }

        int row = grid.length;
        int col = grid[0].length;
        UnionFind unionFind = new UnionFind(grid);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col ; j++) {
                if (grid[i][j] == '1') {
                    grid[i][j] = '0';
                    if (i - 1 >= 0 && grid[i - 1][j] == '1'){
                        unionFind.union(i * row + j, (i - 1) * row + j);
                    }
                    if (i + 1 < row && grid[i + 1][j] == '1'){
                        unionFind.union(i * row + j, (i + 1) * row + j);
                    }
                    if (j - 1 >= 0 && grid[i][j - 1] == '1'){
                        unionFind.union(i * row + j, i * row + j - 1);
                    }
                    if (j + 1 < col && grid[i][j + 1] == '1'){
                        unionFind.union(i * row + j, i * row + j + 1);
                    }
                }
            }
        }
        return unionFind.getCount();
    }

    public static void main(String[] args) {
        char[][] grid = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        int count = numIslands(grid);
        System.out.println("岛屿数量：" + count);
    }
}
