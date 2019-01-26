// 4. Median of Two Sorted Arrays
// Accepted 50ms

class Solution {
    private int[] merge(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int totalLen = len1 + len2;
        int[] wholeNums = new int[totalLen];
        
        for(int i = 0, k = 0, j = 0; k < len1 || j < len2; ) {
            if(k < len1 && j < len2) {
                if(nums1[k] < nums2[j])
                    wholeNums[i++] = nums1[k++];
                
                else if(nums1[k] > nums2[j])
                    wholeNums[i++] = nums2[j++];
                    
                else {
                    wholeNums[i++] = nums1[k++];
                    wholeNums[i++] = nums2[j++];
                }
            }
            
            else if(k < len1)
                wholeNums[i++] = nums1[k++];
            
            else
                wholeNums[i++] = nums2[j++];
        }
        
        return wholeNums;
    }
    
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums = merge(nums1, nums2);
        double ret = 0.0;
        
        if(nums.length > 0) {
            if(nums.length % 2 == 0)
                ret = (((double)nums[nums.length / 2]) + ((double)nums[(nums.length / 2) - 1])) / 2.0;
            else
                ret = (double)nums[nums.length / 2];
        }
        
        return ret;
    }
}
