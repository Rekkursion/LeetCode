// 34. Find First and Last Position of Element in Sorted Array
// Accepted 9ms

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = 0, tmpLeft = 0;
        int right = nums.length - 1, tmpRight = nums.length - 1;
        int mid;
        int leftBound = -1, rightBound = -1;
        boolean firstFound = true;
        int[] ret = new int[2];
        
        while(left <= right) {
            mid = (left + right) / 2;
            
            if(nums[mid] < target)
                left = mid + 1;
            else if(nums[mid] > target)
                right = mid - 1;
            else {
                if(firstFound) {
                    tmpLeft = left;
                    tmpRight = right;
                    firstFound = false;
                }
                
                if(mid - 1 >= 0 && nums[mid - 1] == target) {
                    right = mid - 1;
                }
                else {
                    leftBound = mid;
                    break;
                }
            }
        }
        
        if(leftBound == -1) {
            ret[0] = ret[1] = -1;
            return ret;
        }
        
        left = tmpLeft;
        right = tmpRight;
        
        while(left <= right) {
            mid = (left + right) / 2;
            
            if(nums[mid] < target)
                left = mid + 1;
            else if(nums[mid] > target)
                right = mid - 1;
            else {
                if(mid + 1 < nums.length && nums[mid + 1] == target) {
                    left = mid + 1;
                }
                else {
                    rightBound = mid;
                    break;
                }
            }
        }
        
        System.out.println(leftBound + ", " + rightBound);
        
        ret[0] = leftBound;
        ret[1] = rightBound;
        
        return ret;
    }
}
