# 7. Reverse Integer
# Accepted 52ms

class Solution:
    def reverse(self, x):
        """
        :type x: int
        :rtype: int
        """
        if x == 0: return 0
        
        if x < 0:
            x = -x; isNeg = True
        else:
            isNeg = False
        rev = 0
        
        while x > 0:
            rev = (rev * 10) + (x % 10)
            x //= 10
        
        if isNeg: rev = -rev
        if rev > 2147483647 or rev < -2147483648: rev = 0
        
        return rev
