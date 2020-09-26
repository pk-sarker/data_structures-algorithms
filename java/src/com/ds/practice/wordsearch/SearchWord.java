package com.ds.practice.wordsearch;

public class SearchWord {
    private Integer ROWS = 0;
    private Integer COLUMNS = 0;
    private char[][] board = {};

    public boolean exists(char board[][], String word) {
        System.out.println("Input: " + word);
        this.ROWS = board.length;
        this.COLUMNS = board[0].length;
        this.board = board;
        // System.out.println(this.ROWS);
        // System.out.println(this.COLUMNS);
        for(int i = 0; i < this.ROWS; i++){
            for(int j = 0; j < this.COLUMNS; j++) {
                // System.out.println("----> i=" + i + ", j="+ j+ " | char: " + this.board[i][j]);
                if (this.backtrack(i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtrack(int row, int col, String word, int index) {
        // System.out.println(">> backtrack: row="+row+", col="+col+", word="+word + ", index=" + index);
         // bottom case: we find match for each letter in the word
        if (index >= word.length()) {
            // System.out.println(" - - - Done - - - ");
            return true;
        }

        if (row < 0 || row == this.ROWS || col < 0 || col == this.COLUMNS || this.board[row][col] != word.charAt(index)) {
            return false;
        }
        // System.out.println("row="+row+", col="+col+", char="+this.board[row][col]+ ", word="+word);
        boolean ret = false;

        // mark the choice before exploring further.
        this.board[row][col] = '#';

        //explore the 4 neighbor directions
        int[] rowOffset = {0, 1, 0, -1};
        int[] colOffset = {1, 0, -1, 0};
        for (int i=0; i < 4; i++) {
            // System.out.println(">> >> backtrack: row="+(row + rowOffset[i])+", col="+(col + colOffset[i])+", word="+word + ", index=" + (index+1));
            ret = this.backtrack(row + rowOffset[i], col + colOffset[i], word, index+1);
            if (ret) {
                break;
            }
        }

        // # revert the change, a clean slate and no side-effect
        this.board[row][col] = word.charAt(index);
        return ret;

    }

    public static void main(String[] args) {
        char board[][] = {
                {'A', 'B', 'C', 'G', 'E'},
                {'J', 'K', 'L', 'E', 'F'},
                {'Z', 'Y', 'B', 'C', 'E'},
                {'D', 'K', 'C', 'D', 'B'}};

        SearchWord sw  = new SearchWord();
        boolean found = sw.exists(board, "BCDBE");
        System.out.println("Output: " + found);
        
        boolean found2 = sw.exists(board, "BCDBEE");
        System.out.println("Output: " + found2);

    }
}
