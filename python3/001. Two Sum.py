# 1. Two Sum
# Accepted 4228ms

class Solution:
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        for i, vi in enumerate(nums):
            for j, vj in enumerate(nums[i + 1:]):
                if vi + vj == target:
                    ret = [i, j + i + 1]
                    break
            else:
                continue
            break
        else:
            ret = [0, 0]
        
        return ret
        
