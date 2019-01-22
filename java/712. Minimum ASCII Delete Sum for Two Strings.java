// 712. Minimum ASCII Delete Sum for Two Strings
// Accepted 20ms

class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        
        dp[0][0] = 0;
        for(int k = 1; k <= s1.length(); ++k)
            dp[k][0] = dp[k - 1][0] + s1.charAt(k - 1);
        for(int k = 1; k <= s2.length(); ++k)
            dp[0][k] = dp[0][k - 1] + s2.charAt(k - 1);
        
        for(int i = 1; i <= s1.length(); ++i) {
            for(int j = 1; j <= s2.length(); ++j) {
                if(s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.min(dp[i - 1][j] + s1.charAt(i - 1), dp[i][j - 1] + s2.charAt(j - 1));
            }
        }
        
        return dp[s1.length()][s2.length()];
    }
}
