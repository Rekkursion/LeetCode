# 29. Divide Two Integers
# Accepted 48ms

class Solution:
    def divide(self, dividend, divisor):
        """
        :type dividend: int
        :type divisor: int
        :rtype: int
        """
        if divisor == 0:
            return 2147483647
        
        isNeg = False if (dividend < 0 and divisor < 0) or (dividend >= 0 and divisor >= 0) else True
        dividend, divisor = abs(dividend), abs(divisor)
        
        remainder = dividend
        quotient = 0
        minusor, increment = divisor, 1
        
        while remainder >= divisor:
            if minusor > remainder:
                minusor, increment = divisor, 1
            
            remainder -= minusor
            quotient += increment
            
            minusor += minusor
            increment += increment
        
        quotient = -quotient if isNeg else quotient
        quotient = 2147483647 if quotient < -2147483648 or quotient > 2147483647 else quotient
        
        return quotient
