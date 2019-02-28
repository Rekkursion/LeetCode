// 31. Next Permutation
// Accepted 14ms

class Solution {
    private void swap(int[] nums, int p, int q) {
        int tmp = nums[p];
        nums[p] = nums[q];
        nums[q] = tmp;
        return;
    }
    
    public void nextPermutation(int[] nums) {
        int dropIdx = nums.length - 1;
        int firstBiggerThanDropIdx = nums.length - 1;
        
        for(int k = nums.length - 1; k > 0; --k) {
            if(nums[k - 1] < nums[k]) {
                dropIdx = k - 1;
                
                for(k = nums.length - 1; k > 0; --k) {
                    if(nums[k] > nums[dropIdx]) {
                        firstBiggerThanDropIdx = k;
                        break;
                    }
                }
                break;
            }
        }
        
        swap(nums, dropIdx, firstBiggerThanDropIdx);

        int p = dropIdx == nums.length - 1 ? 0 : dropIdx + 1, q = nums.length - 1;
        while(p < q) {
            swap(nums, p, q);
            p++;
            q--;
        }
        
        return;
    }
}
