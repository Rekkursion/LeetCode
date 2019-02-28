# 5. Longest Palindromic Substring
# Accepted 644ms

class Solution:
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
        sLen = len(s)
        ret = ""
        
        for i, c in enumerate(s):
            p, q = i - 1, i + 1
            while p >= 0 and q < sLen and s[p] == s[q]:
                p -= 1; q += 1
            
            if q - p - 1 > len(ret):
                ret = s[p + 1:q]
            
            if i + 1 < sLen and c == s[i + 1]:
                p, q = i - 1, i + 2
                while p >= 0 and q < sLen and s[p] == s[q]:
                    p -= 1; q += 1
                
                if q - p - 1 > len(ret):
                    ret = s[p + 1:q]
        
        return ret
