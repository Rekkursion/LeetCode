// 63. Unique Paths II
// Accepted 0ms

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0)
            return 0;
        
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        boolean hasObstacle = false;
        
        for(int k = 0; k < obstacleGrid.length; ++k) {
            if(obstacleGrid[k][0] == 1)
                hasObstacle = true;
            dp[k][0] = (hasObstacle) ? 0 : 1;
        }
        hasObstacle = false;
        for(int k = 0; k < obstacleGrid[0].length; ++k) {
            if(obstacleGrid[0][k] == 1)
                hasObstacle = true;
            dp[0][k] = (hasObstacle) ? 0 : 1;
        }
        
        for(int i = 1; i < obstacleGrid.length; ++i) {
            for(int j = 1; j < obstacleGrid[i].length; ++j)
                dp[i][j] = (obstacleGrid[i][j] == 1) ? 0 : dp[i - 1][j] + dp[i][j - 1];
        }
        
        return dp[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }
}
