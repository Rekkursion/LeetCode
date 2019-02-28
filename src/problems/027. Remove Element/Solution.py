# 27. Remove Element
# Accepted 48ms

class Solution:
    def removeElement(self, nums, val):
        """
        :type nums: List[int]
        :type val: int
        :rtype: int
        """
        retIdx = 0
        for idx, num in enumerate(nums):
            if num == val:
                continue
            nums[retIdx] = num
            retIdx += 1
        
        return retIdx
