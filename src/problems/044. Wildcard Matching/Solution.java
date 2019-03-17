// 44. Wildcard Matching
// Accepted 27ms

class Solution {
    public boolean isMatch(String s, String p) {
        int lenS = s.length();
        int lenP = p.length();
        boolean[][] dp = new boolean[lenP + 1][lenS + 1];
        
        dp[0][0] = true;
        for(int j = 1; j <= lenS; ++j)
            dp[0][j] = false;
        for(int k = 1; k <= lenP; ++k)
            dp[k][0] = dp[k - 1][0] && p.charAt(k - 1) == '*';
        
        for(int k = 1; k <= lenP; ++k) {
            for(int j = 1; j <= lenS; ++j) {
                if(p.charAt(k - 1) == '*')
                    dp[k][j] = dp[k - 1][j] || dp[k][j - 1] || dp[k - 1][j - 1];
                else if(p.charAt(k - 1) == '?')
                    dp[k][j] = dp[k - 1][j - 1];
                else
                    dp[k][j] = dp[k - 1][j - 1] && p.charAt(k - 1) == s.charAt(j - 1);
            }
        }
        
        return dp[lenP][lenS];
    }
}
