# 30. Substring with Concatenation of All Words
# Accepted 388ms

class Solution:
    def findSubstring(self, s, words):
        """
        :type s: str
        :type words: List[str]
        :rtype: List[int]
        """
        if len(words) == 0:
            return []
        if '' in words:
            return [i for i in range(len(s) + 1)]
        
        wordLen = len(words[0])
        wordsLen = len(words)
        totalWordsLen = wordsLen * wordLen
        words = {x:words.count(x) for x in set(words)}
        used = words.copy()
        ret = array.array('i')
        
        for idx, ch in enumerate(s[:len(s) - totalWordsLen + 1]):
            cnt, i = 0, idx
            while cnt < wordsLen:
                sub = s[i:i + wordLen]
                if used.get(sub, -1) > 0:
                    used[sub] -= 1
                else:
                    break
                
                cnt += 1
                i += wordLen
            
            if sum(used.values()) == 0:
                ret.append(idx)
            used = words.copy()
        
        return list(ret)
