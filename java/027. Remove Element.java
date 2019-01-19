// 27. Remove Element
// Accepted 9ms

class Solution {
    public int removeElement(int[] nums, int val) {
        int idx = 0;
        
        for(int k = 0; k < nums.length; ++k) {
            if(nums[k] != val)
                nums[idx++] = nums[k];
        }
        
        return idx;
    }
}
