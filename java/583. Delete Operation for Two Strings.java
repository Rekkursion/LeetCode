// 583. Delete Operation for Two Strings
// Accepted 28ms

class Solution {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        
        for(int k = 1; k <= len1; ++k)
            dp[k][0] = k;
        for(int k = 1; k <= len2; ++k)
            dp[0][k] = k;
        dp[0][0] = 0;
        
        for(int i = 1; i <= len1; ++i) {
            for(int j = 1; j <= len2; ++j) {
                if(word1.charAt(i - 1) == word2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
            }
        }
        
        return dp[len1][len2];
    }
}
