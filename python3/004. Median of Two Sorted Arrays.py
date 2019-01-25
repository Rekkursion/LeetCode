# 4. Median of Two Sorted Arrays
# Accepted 152ms

class Solution:
    def merge(self, nums1, nums2):
        i, j, len1, len2 = 0, 0, len(nums1), len(nums2)
        ret = []
        
        while i < len1 and j < len2:
            if nums1[i] < nums2[j]:
                ret.append(nums1[i]); i += 1
            else:
                ret.append(nums2[j]); j += 1
        
        while i < len1:
            ret.append(nums1[i]); i += 1
        while j < len2:
            ret.append(nums2[j]); j += 1
        
        return ret
    
    def findMedianSortedArrays(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: float
        """
        if len(nums1) == 0 and len(nums2) == 0:
            return 0.0
        
        nums = self.merge(nums1, nums2)
        lenNums = len(nums)
        
        return float(nums[lenNums >> 1]) if (lenNums & 1) == 1 else (nums[(lenNums >> 1) - 1] + nums[lenNums >> 1]) / 2.0
