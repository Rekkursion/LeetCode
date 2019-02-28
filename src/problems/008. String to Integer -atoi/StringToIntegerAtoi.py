# 8. String to Integer (atoi)
# Accepted 56ms

class Solution:
    def myAtoi(self, str):
        """
        :type str: str
        :rtype: int
        """
        str = str.lstrip()
        strLen = len(str)
        
        if strLen == 0 or (str[0] != '+' and str[0] != '-' and (str[0] < '0' or str[0] > '9')):
            return 0
        
        if str[0] == '+':
            isNeg = False
            startIdx = 1
        elif str[0] == '-':
            isNeg = True
            startIdx = 1
        else:
            isNeg = False
            startIdx = 0
        
        num = 0
        for c in str[startIdx:]:
            if c < '0' or c > '9': break
            num = (num * 10) + (ord(c) - 48)
        
        if isNeg: num = -num
        if num < -2147483648: num = -2147483648
        if num > 2147483647: num = 2147483647
        
        return num
