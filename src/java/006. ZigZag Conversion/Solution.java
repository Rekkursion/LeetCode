// 6. ZigZag Conversion
// Accepted 63ms

class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1)
            return s;
        
        int modulo = (numRows * 2) - 2;
        int remainder;
        String[] rets = new String[numRows];
        String ret;
        
        for(int k = 0; k < numRows; k++)
            rets[k] = "";
        
        for(int k = 0; k < s.length(); ++k) {
            remainder = k % modulo;
            
            if(remainder < numRows) {
                rets[remainder] += s.charAt(k);
            }
            
            else {
                rets[modulo - remainder] += s.charAt(k);
            }
        }
        
        ret = "";
        for(int k = 0; k < numRows; k++)
            ret += rets[k];
        
        return ret;
    }
}
