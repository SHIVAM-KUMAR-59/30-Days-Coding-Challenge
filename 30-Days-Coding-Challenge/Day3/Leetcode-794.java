
// 794. Valid Tic-Tac-Toe State
// Question Link - https://leetcode.com/problems/valid-tic-tac-toe-state/description/
// Given a Tic-Tac-Toe board as a string array board, return true if and only if it is possible to reach this board position during the course of a valid tic-tac-toe game.
// The board is a 3 x 3 array that consists of characters ' ', 'X', and 'O'. The ' ' character represents an empty square.

class Solution {
    public boolean validTicTacToe(String[] board) {
        // if board is empty it's valid
        if (board.length == 0) {
            return true;
        }
        int count_x = 0;
        int count_o = 0;
        int empty_count = 0;
        // check the count for X, O and empty cell
        for (String s : board) {
            for (char c : s.toCharArray()) {
                if (c == 'X') {
                    count_x++;
                } else if (c == 'O') {
                    count_o++;
                } else {
                    empty_count++;
                }
            }
        }
        boolean x_won = checkForWin(board, 'X');
        boolean o_won = checkForWin(board, 'O');
        if (empty_count == 9) { // if the board is empty ( 3 X 3 =9)
            return true;
        } else if (count_o > count_x) { // count for O can't be greater because X starts first
            return false;
        } else if (x_won && o_won) { // both can't win at the same time
            return false;
        } else if (o_won && count_x > count_o) { // if O wins but X tried putting even after O won
            return false;
        } else if (x_won && count_x - count_o == 0) { // X wins but O tried putting even after X won
            return false;
        } else if (count_x - count_o == 1) { // X is always 1 step ahead of O
            return true;
        } else if (count_x == count_o && empty_count > 0) { // if X and O have same count then there are more than one
                                                            // empty cells in the grid
            return true;
        }
        return false;
    }

    /* Method to check if X won or O won */
    public boolean checkForWin(String[] board, char check_for) {
        char[][] b = new char[3][3];
        // store this in 3 X 3 matrix called 'b' for simplicity and better readability
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                char[] arr = board[r].toCharArray();
                b[r][c] = arr[c];
            }
        }
        // check for rows
        for (int r = 0; r < 3; r++) {
            if (b[r][0] == b[r][1] && b[r][0] == b[r][2] && b[r][0] == check_for) {
                return true;
            }
        }
        // check for cols
        for (int c = 0; c < 3; c++) {
            if (b[0][c] == b[1][c] && b[0][c] == b[2][c] && b[2][c] == check_for) {
                return true;
            }
        }
        // check for diagonal
        if (b[0][0] == b[1][1] && b[0][0] == b[2][2] && b[0][0] == check_for) {
            return true;
        }
        // check for anti-diagonal
        if (b[0][2] == b[1][1] && b[2][0] == b[1][1] && b[1][1] == check_for) {
            return true;
        }
        // the player didn't win
        return false;
    }

}