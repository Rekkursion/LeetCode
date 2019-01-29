# 28. Implement strStr()
# Accepted 52ms

class Solution:
    def make_prefix(self, pattern):
        prefix = [0]
        i, leng = 1, 0
        
        while i < len(pattern):
            if pattern[i] == pattern[leng]:
                leng += 1
                prefix.append(leng)
            else:
                if leng == 0:
                    prefix.append(0)
                else:
                    leng = prefix[leng - 1]
                    continue
            i += 1
        
        prefix = [-1] + prefix[:len(prefix) - 1]
        return prefix
    
    def kmp_search(self, text, pattern):
        if pattern == '':
            return 0
        if len(pattern) > len(text):
            return -1
        
        prefix = self.make_prefix(pattern)
        
        t = p = 0
        while t < len(text):
            if text[t] == pattern[p]:
                # found
                if p == len(pattern) - 1:
                    return t - p
                t += 1
                p += 1
            else:
                p = prefix[p]
                if p == -1:
                    t += 1
                    p += 1
        
        return -1
    
    def strStr(self, haystack, needle):
        """
        :type haystack: str
        :type needle: str
        :rtype: int
        """
        return self.kmp_search(haystack, needle)
