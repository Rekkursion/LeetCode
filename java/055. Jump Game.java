// 55. Jump Game
// Accepted 687ms

class Solution {
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length == 0)
            return false;
        
        int[] dp = new int[nums.length];
        
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        
        for(int k = 0; k < nums.length; ++k) {
            for(int j = 1; j <= nums[k] && k + j < nums.length && dp[k] != Integer.MAX_VALUE; ++j) {
                if(dp[k + j] == Integer.MAX_VALUE || dp[k] + 1 < dp[k + j])
                    dp[k + j] = dp[k] + 1;
            }
        }
        
        return (dp[nums.length - 1] != Integer.MAX_VALUE);
    }
}
