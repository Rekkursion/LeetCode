// 221. Maximal Square
// Accepted 24ms

class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;
        
        int[][] rowAcc = new int[matrix.length][matrix[0].length];
        int curWidth, curHeight, curMax, finalMax;
        
        for(int k = 0; k < matrix.length; ++k) {
            for(int j = 0; j < matrix[k].length; ++j)
                rowAcc[k][j] = matrix[k][j] == '0' ? 0 : (j == 0 ? 0 : rowAcc[k][j - 1]) + 1;
        }
        
        finalMax = 0;
        for(int k = 0; k < matrix.length; ++k) {
            for(int j = 0; j < matrix[k].length; ++j) {
                if(matrix[k][j] == '0')
                    continue;
                
                curMax = 1;
                curWidth = rowAcc[k][j];
                
                for(int i = k - 1; i >= 0; --i) {
                    curWidth = Math.min(curWidth, rowAcc[i][j]);
                    if(curWidth == 0)
                        break;
                    curHeight = (k - i) + 1;
                    curMax = Math.max(curMax, Math.min(curWidth, curHeight) * Math.min(curWidth, curHeight));
                }
                
                finalMax = Math.max(finalMax, curMax);
            }
        }
        
        return finalMax;
    }
}
