// 37. Sudoku Solver
// Accepted 16ms

class Solution {
    private char[][] ret;
    private boolean[][] hori;
    private boolean[][] vert;
    private boolean[][] gong;
    private boolean found;
    
    private boolean canPut(int row, int col, int num) {
        return (!hori[row][num] && !vert[col][num] && !gong[((row / 3) * 3) + (col / 3)][num]);
    }
    
    private void dfs(char[][] board) {
        if(found)
            return;
        
        for(int k = 0; k < 9; k++) {
            for(int j = 0; j < 9; j++) {
                if(board[k][j] == '.') {
                    
                    for(int i = 1; i <= 9; i++) {
                        if(canPut(k, j, i)) {
                            hori[k][i] = true;
                            vert[j][i] = true;
                            gong[((k / 3) * 3) + (j / 3)][i] = true;
                            board[k][j] = (char)(i + '0');
                            
                            dfs(board);
                            
                            hori[k][i] = false;
                            vert[j][i] = false;
                            gong[((k / 3) * 3) + (j / 3)][i] = false;
                            board[k][j] = '.';
                        }
                    }
                    
                    return;
                }
            }
        }
        
        found = true;
        
        for(int k = 0; k < 9; k++) {
            for(int j = 0; j < 9; j++)
                ret[k][j] = board[k][j];
        }
        
        return;
    }
    
    public void solveSudoku(char[][] board) {
        found = false;
        hori = new boolean[9][10];
        vert = new boolean[9][10];
        gong = new boolean[9][10];
        ret = new char[9][9];
        
        for(int k = 0; k < 9; k++) {
            for(int j = 0; j < 9; j++) {
                if(board[k][j] != '.') {
                    hori[k][board[k][j] - '0'] = true;
                    vert[j][board[k][j] - '0'] = true;
                    gong[((k / 3) * 3) + (j / 3)][board[k][j] - '0'] = true;
                }
            }
        }
        
        dfs(board);
        
        for(int k = 0; k < 9; k++) {
            for(int j = 0; j < 9; j++)
                board[k][j] = ret[k][j];
        }
        
        return;
    }
}
