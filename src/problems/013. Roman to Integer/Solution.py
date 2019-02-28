# 13. Roman to Integer
# Accepted 144ms

class Solution:
    def romanToInt(self, s):
        """
        :type s: str
        :rtype: int
        """
        values = { 'M': 1000, 'D': 500, 'C': 100, 'L': 50, 'X': 10, 'V': 5, 'I': 1 }
        num = 0
        for i, c in enumerate(s):
            if i + 1 < len(s) and values[s[i + 1]] > values[c]:
                num -= values[c]
            else:
                num += values[c]
        
        return num
