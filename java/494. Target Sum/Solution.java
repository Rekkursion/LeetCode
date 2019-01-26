// 494. Target Sum
// Accepted 689ms

class Solution {
    private int ret;
    
    private void dfs(int sum, int idx, final int[] NUMS, final int TARGET) {
        if(idx == NUMS.length) {
            if(sum == TARGET)
                ret++;
            
            return;
        }
        
        dfs(sum + NUMS[idx], idx + 1, NUMS, TARGET);
        dfs(sum - NUMS[idx], idx + 1, NUMS, TARGET);
        
        return;
    }
    
    public int findTargetSumWays(int[] nums, int S) {
        ret = 0;
        dfs(0, 0, nums, S);
        
        return ret;
    }
}
