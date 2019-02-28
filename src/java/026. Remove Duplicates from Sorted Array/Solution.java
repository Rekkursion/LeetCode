// 26. Remove Duplicates from Sorted Array
// Accepted 10ms

class Solution {
    public int removeDuplicates(int[] nums) {
        int len = nums.length, idx = 0;
        
        for(int k = 0; k < nums.length; ++k) {
            while(k + 1 < nums.length && nums[k] == nums[k + 1]) {
                k++;
                len--;
            }
            
            nums[idx++] = nums[k];
        }
        
        return len;
    }
}
