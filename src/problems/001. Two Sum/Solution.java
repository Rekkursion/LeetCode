// 1. Two Sum
// Accepted 41ms

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] retIdcs = new int[2];
        
        for(int k = 0; k < nums.length; k++) {
            for(int j = k + 1; j < nums.length; j++) {
                if(nums[k] + nums[j] == target) {
                    retIdcs[0] = k;
                    retIdcs[1] = j;
                    k = nums.length;
                    
                    break;
                }
            }
        }
        
        return retIdcs;
    }
}
