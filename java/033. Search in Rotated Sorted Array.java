// 33. Search in Rotated Sorted Array
// Accepted 11ms

class Solution {
    private int findOffset(int[] nums) {
        for(int k = 1; k < nums.length; ++k) {
            if(nums[k] < nums[k - 1])
                return k;
        }
        
        return 0;
    }
    
    private int binarySearchWithOffset(int[] nums, int target, int offset) {
        if(nums == null || nums.length == 0)
            return -1;
        
        int len = nums.length;
        int left = offset, right = len + offset - 1;
        int mid, midAfterModulo, lastMid = -1;
        
        while(left <= right) {
            mid = (left + right) >>> 1;
            midAfterModulo = mid % len;
            
            if(mid == lastMid)
                break;
            lastMid = mid;
            
            if(nums[midAfterModulo] == target)
                return midAfterModulo;
            else if(nums[midAfterModulo] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        
        return -1;
    }
    
    public int search(int[] nums, int target) {
        return binarySearchWithOffset(nums, target, findOffset(nums));
    }
}
