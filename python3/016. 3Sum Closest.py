# 16. 3Sum Closest
# Accepted 100ms

class Solution:
    def threeSumClosest(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        minGap = 2147483648
        ret = 0
        
        nums.sort()
        for i, _ in enumerate(nums):
            p, q = i + 1, len(nums) - 1
            while p < q:
                val = nums[i] + nums[p] + nums[q]
                if val == target:
                    return val
                elif val < target:
                    p += 1
                else:
                    q -= 1
                
                if abs(val - target) < minGap:
                    ret = val
                    minGap = abs(val - target)
        
        return ret
                    
