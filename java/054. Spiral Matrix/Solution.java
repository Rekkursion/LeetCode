// 54. Spiral Matrix
// Accepted 3ms

class Solution {
    private void dfs(int row, int col, boolean[][] used, List<Integer> ret, final int[][] MAT) {
        // right
        if(col + 1 < MAT[row].length && !used[row][col + 1] && (row == 0 || used[row - 1][col])) {
            used[row][col + 1] = true;
            ret.add(MAT[row][col + 1]);
            
            dfs(row, col + 1, used, ret, MAT);
        }
        
        // down
        else if(row + 1 < MAT.length && !used[row + 1][col]) {
            used[row + 1][col] = true;
            ret.add(MAT[row + 1][col]);
            
            dfs(row + 1, col, used, ret, MAT);
        }
        
        // left
        else if(col - 1 >= 0 && !used[row][col - 1]) {
            used[row][col - 1] = true;
            ret.add(MAT[row][col - 1]);
            
            dfs(row, col - 1, used, ret, MAT);
        }
        
        // up
        else if(row - 1 >= 0 && !used[row - 1][col]) {
            used[row - 1][col] = true;
            ret.add(MAT[row - 1][col]);
            
            dfs(row - 1, col, used, ret, MAT);
        }
        
        return;
    }
    
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ret = new ArrayList<>();
        boolean[][] used;
        
        if(matrix.length == 0 || matrix[0].length == 0)
            return ret;
        
        used = new boolean[matrix.length][matrix[0].length];
        used[0][0] = true;
        
        ret.add(matrix[0][0]);
        dfs(0, 0, used, ret, matrix);
        
        return ret;
    }
}
