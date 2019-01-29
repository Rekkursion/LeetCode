# 26. Remove Duplicates from Sorted Array
# Accepted 56ms

class Solution:
    def removeDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        numsLen = len(nums)
        retIdx = 0
        for idx, num in enumerate(nums):
            if idx + 1 < numsLen and num == nums[idx + 1]:
                continue
            nums[retIdx] = num
            retIdx += 1
        
        return retIdx
