// 35. Search Insert Position
// Accepted 4ms

class Solution {
    public int searchInsert(int[] nums, int target) {
        
        for(int k = -1; k < nums.length; k++) {
            if(k + 1 < nums.length && nums[k + 1] >= target)
                return k + 1;
        }
        
        return nums.length;
    }
}
