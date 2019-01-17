// 59. Spiral Matrix II
// Accepted 2ms

class Solution {
    private void dfs(int row, int col, int num, int[][] ret, final int GOAL) {
        // right
        if(col + 1 < ret[row].length && ret[row][col + 1] == 0 && (row == 0 || ret[row - 1][col] != 0)) {
            ret[row][col + 1] = num;
            dfs(row, col + 1, num + 1, ret, GOAL);
        }
        
        // down
        else if(row + 1 < ret.length && ret[row + 1][col] == 0) {
            ret[row + 1][col] = num;
            dfs(row + 1, col, num + 1, ret, GOAL);
        }
        
        // left
        else if(col - 1 >= 0 && ret[row][col - 1] == 0) {
            ret[row][col - 1] = num;
            dfs(row, col - 1, num + 1, ret, GOAL);
        }
        
        // up
        else if(row - 1 >= 0 && ret[row - 1][col] == 0) {
            ret[row - 1][col] = num;
            dfs(row - 1, col, num + 1, ret, GOAL);
        }
        
        return;
    }
    
    public int[][] generateMatrix(int n) {
        int[][] ret = new int[n][n];
        int goal = n * n;
        
        if(n == 0)
            return ret;
        
        for(int[] arr_1d: ret)
            Arrays.fill(arr_1d, 0);
        ret[0][0] = 1;
        
        dfs(0, 0, 2, ret, goal);
        
        return ret;
    }
}
