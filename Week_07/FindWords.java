package com.qunar.qboss.qer.common.lianxi.week07;

import java.util.ArrayList;
import java.util.List;

public class FindWords {
    char[][] _board = null;
    List<String> resultList = new ArrayList<>();

    public List<String> findWords(char[][] board,String[] wrords) {
        // Step 1). Construct the Trie
        TrieNode01 root = new TrieNode01();
        for (String word : wrords) {
            TrieNode01 node = root;
            for (char letter : word.toCharArray()) {
                if (node.children.containsKey(letter)) {
                    node = node.children.get(letter);
                }else {
                    TrieNode01 newNode = new TrieNode01();
                    node.children.put(letter,newNode);
                    node = newNode;
                }
            }
            // store words in Trie
            node.word = word;
        }

        // Step 2). Backtracking starting for each cell in the board
        this._board = board;
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (root.getChildren().containsKey(board[row][col])) {
                    backtracking(row, col, root);
                }
            }
        }
        return this.resultList;
    }

    private void backtracking(int row, int col, TrieNode01 parent) {
        Character letter = this._board[row][col];
        TrieNode01 currNode = parent.children.get(letter);

        // check if there is any match
        if (currNode.word != null){
            this.resultList.add(currNode.word);
            currNode.word = null;

        }

        // mark the current letter before the EXPLORATION
        this._board[row][col] = '#';

        // explore neighbor cells in around-clock directions: up, right, down, left
        int[] rowOffset = {-1,0,1,0};
        int[] colOffset = {0,-1,0,1};
        for (int i = 0; i < 4 ; i++) {
            int newRow = row + rowOffset[i];
            int newCol = col + colOffset[i];
            if (newRow < 0 || newRow >= this._board.length
                    || newCol < 0 || newCol >= this._board[0].length) {
                continue;
            }

            if (currNode.children.containsKey(this._board[newRow][newCol])) {
                backtracking(newRow,newCol,currNode);
            }
        }

        // End of EXPLORATION, restore the original letter in the board.
        this._board[row][col] = letter;

        // Optimization: incrementally remove the leaf nodes
        if (currNode.children.isEmpty()) {
            parent.children.remove(letter);
        }

    }
}


