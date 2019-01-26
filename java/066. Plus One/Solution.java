// 66. Plus One
// Accepted 0ms

class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1, sum;
        
        for(int k = digits.length - 1; k >= 0; k--) {
            sum = digits[k] + carry;
            carry = sum / 10;
            digits[k] = sum % 10;
            
            if(carry == 0)
                return digits;
        }
        
        int[] ret = new int[digits.length + 1];
        for(int k = 1; k <= digits.length; k++)
            ret[k] = digits[k - 1];
        ret[0] = 1;
        
        return ret;
    }
}
