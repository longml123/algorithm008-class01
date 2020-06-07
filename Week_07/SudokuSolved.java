package com.qunar.qboss.qer.common.lianxi.week07;

public class SudokuSolved {
    //方块长度
    int n = 3;
    int m = n * n;

    int[][] rows = new int[m][m + 1];
    int[][] columns = new int[m][m + 1];
    int[][] boxs = new int[m][m + 1];

    char[][] board;
    boolean sudokuSolved = false;

     /**
    Check if one could place a number d in (row, col) cell
    */
     public boolean couldPlace(int d, int row,int col){
         //方块索引= (行 / 3) * 3 + 列 / 3
         int idx = (row / n) * n + col / n;
         return rows[row][d] + columns[col][d] + boxs[idx][d] == 0;
     }

     /**
    Place a number d in (row, col) cell
    */
    public void placeNumber(int d, int row,int col) {
        //方块索引= (行 / 3) * 3 + 列 / 3
        int idx = (row / n) * n + col / n;

        rows[row][d]++;
        columns[col][d]++;
        boxs[idx][d]++;
        board[row][col] = (char)(d + '0');
    }
    /**
   Remove a number which didn't lead to a solution
   */
    public void removeNumber(int d, int row,int col) {
        //方块索引= (行 / 3) * 3 + 列 / 3
        int idx = (row / n) * n + col / n;

        rows[row][d]--;
        columns[col][d]--;
        boxs[idx][d]--;
        board[row][col] = '.';
    }

    /**
    Call backtrack function in recursion
    to continue to place numbers
    till the moment we have a solution
    */
    public void placeNextNumbers(int row, int col) {
        // if we're in the last cell
        // that means we have the solution
        if (row == m - 1 && col == m - 1){
            sudokuSolved = true;
        }else {
            if (col == m - 1) {
                backtrack(row + 1, 0);
            }else {
                backtrack(row ,col + 1);
            }
        }

    }
     /**
    Backtracking
    */
     public void  backtrack(int row, int col) {
         if (board[row][col] == '.') {
             for (int d = 1; d < 10 ; d++) {
                 if (couldPlace(d, row,col)) {
                     placeNumber(d,row,col);
                     placeNextNumbers(row,col);
                     if (!sudokuSolved) {
                         removeNumber(d,row,col);
                     }
                 }
             }
         }else {
             placeNextNumbers(row,col);
         }
     }

    public void solveSudoku(char[][] board){
         this.board = board;
        for (int i = 0; i < m ; i++) {
            for (int j = 0; j < m ; j++) {
                char numChar = board[i][j];
                if (numChar != '.') {
                    int d = Character.getNumericValue(numChar);
                    placeNumber(d,i,j);
                }
            }
        }
        backtrack(0,0);
    }

}
