// 8. String to Integer (atoi)
// Accepted 29ms

class Solution {
    public int myAtoi(String str) {
        boolean isNegative = false;
        char c;
        long ret = 0L;
        int numericalStartIdx = 0;
        
        // Find the first non-whitespace character
        for(int k = 0; k < str.length(); ++k) {
            c = str.charAt(k);
            
            if(c != ' ') {
                if(c >= '0' && c <= '9')
                    ret = (long)(c - '0');
                
                else if(c == '+') {
                    ret = 0L;
                }
                
                else if(c == '-') {
                    ret = 0L;
                    isNegative = true;
                }
                
                else
                    return 0;
                
                numericalStartIdx = k + 1;
                break;
            }
        }
        
        // Find integral number from numericalStartIdx
        for(int k = numericalStartIdx; k < str.length(); ++k) {
            c = str.charAt(k);
            
            if(c >= '0' && c <= '9')
                ret = (ret * 10L) + (long)(c - '0');
            else
                break;
            
            if(ret > (long)Integer.MAX_VALUE * 10L) {
                ret = (long)Integer.MAX_VALUE + 2L;
                break;
            }
        }
        
        if(isNegative)
            ret *= -1L;
        
        if(ret < (long)Integer.MIN_VALUE)
            ret = (long)Integer.MIN_VALUE;
        
        if(ret > (long)Integer.MAX_VALUE)
            ret = (long)Integer.MAX_VALUE;
        
        return (int)ret;
    }
}
