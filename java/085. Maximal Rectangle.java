// 85. Maximal Rectangle
// Accepted 32ms

class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;
        
        int[][] rowAcc = new int[matrix.length][matrix[0].length];
        int curMax, curLen, finalMax;
        
        finalMax = 0;
        for(int k = 0; k < matrix.length; ++k) {
            for(int j = 0; j < matrix[k].length; ++j) {
                rowAcc[k][j] = matrix[k][j] == '0' ? 0 : (j == 0 ? 0 : rowAcc[k][j - 1]) + 1;
                if(k == 0)
                    finalMax = Math.max(finalMax, rowAcc[k][j]);
            }
        }
        
        for(int k = 1; k < matrix.length; ++k) {
            for(int j = 0; j < matrix[k].length; ++j) {
                curMax = curLen = rowAcc[k][j];
                
                for(int i = k - 1; i >= 0; --i) {
                    curLen = Math.min(curLen, rowAcc[i][j]);
                    curMax = Math.max(curMax, curLen * ((k - i) + 1));
                }
                
                finalMax = Math.max(finalMax, curMax);
            }
        }
        
        return finalMax;
    }
}
