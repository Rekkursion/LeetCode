// 45. Jump Game II
// Accepted 635ms

class Solution {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        
        for(int k = 0; k < nums.length; ++k) {
            for(int j = 1; j <= nums[k] && dp[k] != Integer.MAX_VALUE && k + j < nums.length; ++j) {
                if(dp[k + j] == Integer.MAX_VALUE || dp[k] + 1 < dp[k + j])
                    dp[k + j] = dp[k] + 1;
            }
        }
        
        return dp[nums.length - 1];
    }
}
