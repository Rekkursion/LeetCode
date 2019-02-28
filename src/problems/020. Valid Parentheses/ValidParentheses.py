# 20. Valid Parentheses
# Accepted 32ms

class Solution:
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        stack = []
        for c in s:
            if c == '(' or c == '{' or c == '[':
                stack.append(c)
            else:
                if len(stack) > 0:
                    top = stack.pop()
                    if not ((c == ')' and top == '(') or (c == '}' and top == '{') or (c == ']' and top == '[')):
                        return False
                else:
                    return False
        
        if len(stack) > 0:
            return False
        return True
