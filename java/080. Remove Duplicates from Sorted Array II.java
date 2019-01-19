// 80. Remove Duplicates from Sorted Array II
// Accepted 13ms

class Solution {
    public int removeDuplicates(int[] nums) {
        int len = nums.length, idx = 0, sameCount;
        
        for(int k = 0; k < nums.length; ++k) {
            sameCount = 1;
            while(k + 1 < nums.length && nums[k] == nums[k + 1]) {
                k++;
                sameCount++;
            }
            
            if(sameCount == 1)
                nums[idx++] = nums[k];
            else {
                nums[idx++] = nums[k];
                nums[idx++] = nums[k];
                len -= sameCount - 2;
            }
        }
        
        return len;
    }
}
