// 65. Valid Number
// Accepted 44ms

class Solution {
    private enum NumberMode {
        INTEGER_MODE, FRACTION_MODE, EXPONENTIAL_MODE
    }
    
    public boolean isNumber(String s) {
        if(s == null)
            return false;
        
        s = s.trim();
        if(s.length() == 0)
            return false;
        
        int startIdx = 0;
        NumberMode mode = NumberMode.INTEGER_MODE;
        boolean hasValidExp = true, hasValidBase = false;
        
        if(s.charAt(0) >= '0' && s.charAt(0) <= '9')
            hasValidBase = true;
        else if(s.charAt(0) == '+' || s.charAt(0) == '-')
            startIdx = 1;
        else if(s.charAt(0) == '.') {
            startIdx = 1;
            mode = NumberMode.FRACTION_MODE;
        }
        else
            return false;
        
        for(int k = startIdx; k < s.length(); ++k) {
            if(s.charAt(k) >= '0' && s.charAt(k) <= '9') {
                if(mode == NumberMode.EXPONENTIAL_MODE)
                    hasValidExp = true;
                else
                    hasValidBase = true;
            }
            else if(s.charAt(k) == '.') {
                if(mode == NumberMode.INTEGER_MODE)
                    mode = NumberMode.FRACTION_MODE;
                else
                    return false;
            }
            else if(s.charAt(k) == 'e') {
                if(mode == NumberMode.EXPONENTIAL_MODE)
                    return false;
                else
                    mode = NumberMode.EXPONENTIAL_MODE;
                
                if(k + 1 < s.length() && (s.charAt(k + 1) == '+' || s.charAt(k + 1) == '-'))
                    ++k;
                hasValidExp = false;
            }
            else
                return false;
        }
        
        return (hasValidExp && hasValidBase);
    }
}
