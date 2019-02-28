# 3. Longest Substring Without Repeating Characters
# Accepted 620ms

class Solution:
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        maxLen = 0
        for i, ci in enumerate(s):
            used = [False] * 256
            
            for j, cj in enumerate(s[i:]):
                if used[ord(cj)] == True:
                    maxLen = max(maxLen, j)
                    break
                used[ord(cj)] = True
            else:
                maxLen = max(maxLen, len(s) - i)
        else:
            pass
        
        return maxLen
        
