# 6. ZigZag Conversion
# Accepted 76ms

class Solution:
    def convert(self, s, numRows):
        """
        :type s: str
        :type numRows: int
        :rtype: str
        """
        if numRows == 1:
            return s
        
        modulo = (numRows << 1) - 2
        zigzag = ["" for x in range(0, numRows)]
        
        for idx, val in enumerate(s):
            remainder = idx % modulo
            if remainder < numRows:
                zigzag[remainder] += val
            else:
                zigzag[modulo - remainder] += val
        
        return ''.join(zigzag)
