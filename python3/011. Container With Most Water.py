# 11. Container With Most Water
# Accepted 64ms

class Solution:
    def maxArea(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        hLen = len(height)
        head, tail = 0, hLen - 1
        maxWater = 0
        
        while head < tail:
            maxWater = max(maxWater, min(height[head], height[tail]) * (tail - head))
            if height[head] < height[tail]:
                head += 1
            elif height[head] > height[tail]:
                tail -= 1
            else:
                head += 1; tail -= 1
        
        return maxWater
