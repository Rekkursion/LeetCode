# 31. Next Permutation
# Accepted 44ms

class Solution:
    def nextPermutation(self, nums):
        """
        :type nums: List[int]
        :rtype: void Do not return anything, modify nums in-place instead.
        """
        firstBiggerThanDropIdx = len(nums) - 1
        dropIdx = 0
        
        for i, v in enumerate(nums[::-1]):
            if i == len(nums) - 1 or (v > nums[-i - 2]):
                dropIdx = len(nums) - i - 2
                
                for j, vj in enumerate(nums[::-1]):
                    if vj > nums[dropIdx]:
                        firstBiggerThanDropIdx = len(nums) - j - 1
                        break
                break
        if dropIdx != -1:
            nums[dropIdx], nums[firstBiggerThanDropIdx] = nums[firstBiggerThanDropIdx], nums[dropIdx]
        
        revIdx = len(nums) - 1
        for idx, val in enumerate(nums[dropIdx + 1:]):
            if revIdx <= idx + dropIdx + 1:
                break
            nums[idx + dropIdx + 1], nums[revIdx] = nums[revIdx], val
            revIdx -= 1
        
        return None
