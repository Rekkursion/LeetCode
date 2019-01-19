// 48. Rotate Image
// Accepted 2ms

class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int row, col, cur, next;
        
        for(int k = 0; k < n; ++k) {
            for(int j = k; j < n - k - 1; ++j) {
                row = k;
                col = j;
                
                next = matrix[j][n - k - 1];
                matrix[j][n - k - 1] = matrix[k][j];
                
                cur = next;
                next = matrix[n - k - 1][n - j - 1];
                matrix[n - k - 1][n - j - 1] = cur;
                
                cur = next;
                next = matrix[n - j - 1][k];
                matrix[n - j - 1][k] = cur;
                
                matrix[k][j] = next;
            }
        }
        
        return;
    }
}
