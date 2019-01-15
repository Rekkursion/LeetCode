// 36. Valid Sudoku
// Accepted 24ms

class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] hori = new boolean[9][10];
        boolean[][] vert = new boolean[9][10];
        boolean[][] gong = new boolean[9][10];
        
        for(int k = 0; k < 9; k++) {
            for(int j = 0; j < 9; j++) {
                if(board[k][j] != '.') {
                    if(hori[k][board[k][j] - '0'] || vert[j][board[k][j] - '0'] || gong[((k / 3) * 3) + (j / 3)][board[k][j] - '0'])
                        return false;

                    hori[k][board[k][j] - '0'] = true;
                    vert[j][board[k][j] - '0'] = true;
                    gong[((k / 3) * 3) + (j / 3)][board[k][j] - '0'] = true;
                }
            }
        }
        
        return true;
    }
}
