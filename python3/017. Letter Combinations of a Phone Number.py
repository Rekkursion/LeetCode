# 17. Letter Combinations of a Phone Number
# Accepted 36ms

class Solution:
    letters = {
        '1': '',
        '2': 'abc',
        '3': 'def',
        '4': 'ghi',
        '5': 'jkl',
        '6': 'mno',
        '7': 'pqrs',
        '8': 'tuv',
        '9': 'wxyz',
        '0': ''
    }
    
    def dfs(self, idx, row, ret, digits):
        if idx == len(digits):
            if row != '':
                ret.append(row)
            return
        
        letterStr = self.letters[digits[idx]] if self.letters.__contains__(digits[idx]) else ''
        for ch in letterStr:
            self.dfs(idx + 1, row + ch, ret, digits)
    
    def letterCombinations(self, digits):
        """
        :type digits: str
        :rtype: List[str]
        """
        
        ret = []
        self.dfs(0, '', ret, digits)
        
        return ret
