# 22. Generate Parentheses
# Accepted 36ms

class Solution:
    def dfs(self, opened, closed, row, ret, N):
        if opened == N and closed == N:
            ret.append(row)
            return
        
        if opened < N:
            self.dfs(opened + 1, closed, row + '(', ret, N)
        if closed < opened:
            self.dfs(opened, closed + 1, row + ')', ret, N)
        
        return
    
    def generateParenthesis(self, n):
        """
        :type n: int
        :rtype: List[str]
        """
        ret = []
        self.dfs(0, 0, '', ret, n)
        
        return ret
