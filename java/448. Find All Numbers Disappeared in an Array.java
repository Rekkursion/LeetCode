// 448. Find All Numbers Disappeared in an Array
// Accepted 14ms

class Solution {
    private void swap(int[] arr, int p, int q) {
        int tmpVal = arr[p];
        arr[p] = arr[q];
        arr[q] = tmpVal;
        return;
    }
    
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ret = new ArrayList<>();
        
        for(int k = 0; k < nums.length; ++k) {
            while(nums[k] != k + 1 && nums[k] != nums[nums[k] - 1])
                swap(nums, k, nums[k] - 1);
        }
        
        for(int k = 0; k < nums.length; ++k) {
            if(nums[k] != k + 1)
                ret.add(k + 1);
        }
        
        return ret;
    }
}
