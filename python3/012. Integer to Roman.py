# 12. Integer to Roman
# Accepted 112ms

class Solution:
    def intToRoman(self, num):
        """
        :type num: int
        :rtype: str
        """
        units = (1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1)
        symbols = ('M', 'CM', 'D', 'CD', 'C', 'XC', 'L', 'XL', 'X', 'IX', 'V', 'IV', 'I')
        roman = ''
        
        for unit, symbol in zip(units, symbols):
            roman += symbol * (num // unit)
            num %= unit
        
        return roman
