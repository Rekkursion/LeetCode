// 516. Longest Palindromic Subsequence
// Accepted 67ms

class Solution {
    public int longestPalindromeSubseq(String s) {
        String r = new StringBuffer(s).reverse().toString();
        int[][] dp = new int[s.length() + 1][s.length() + 1];
        
        Arrays.fill(dp[0], 0);
        for(int k = 1; k <= s.length(); ++k)
            dp[k][0] = 0;
        
        for(int i = 1; i <= s.length(); ++i) {
            for(int j = 1; j <= r.length(); ++j) {
                if(s.charAt(i - 1) == r.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(Math.max(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]);
            }
        }
        
        return dp[s.length()][r.length()];
    }
}
