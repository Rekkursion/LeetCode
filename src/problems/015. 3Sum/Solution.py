# 15. 3Sum
# Accepted 2468ms

class Solution:
    def threeSum(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        ret = dict()
        
        nums.sort()
        for i, num_i in enumerate(nums):
            p, q = i + 1, len(nums) - 1
            while p < q:
                curVal = num_i + nums[p] + nums[q]
                if curVal < 0:
                    p += 1
                elif curVal > 0:
                    q -= 1
                else:
                    ret[str(num_i) + str(nums[p]) + str(nums[q])] = [num_i, nums[p], nums[q]]
                    p += 1; q -= 1
        
        return list(ret.values())
