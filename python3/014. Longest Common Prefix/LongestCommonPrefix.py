# 14. Longest Common Prefix
# Accepted 36ms

class Solution:
    def longestCommonPrefix(self, strs):
        """
        :type strs: List[str]
        :rtype: str
        """
        if strs == []:
            return ""
        
        prefix = ''
        maxStrLen = max([len(x) for x in strs])
        for i in range(0, maxStrLen):
            ch = {x[i] if i < len(x) else ' ' for x in strs}
            if len(ch) == 1:
                prefix += ch.pop()
            else:
                break
        
        return prefix
