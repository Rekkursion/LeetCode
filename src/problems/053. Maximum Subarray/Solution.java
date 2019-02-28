// 53. Maximum Subarray
// Accepted 6ms

class Solution {
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        
        int sum = 0, maxValue = nums[0];
        for(int k = 0; k < nums.length; ++k) {
            if(sum < 0)
                sum = 0;
            sum += nums[k];
            maxValue = Math.max(sum, maxValue);
        }
        
        return maxValue;
    }
}
