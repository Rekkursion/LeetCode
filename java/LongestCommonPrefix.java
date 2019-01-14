// 14. Longest Common Prefix
// Accepted 10ms

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0)
            return "";
        
        
        int dig = 0;
        boolean continueFlag = true;
        String ret = "";
        
        while(continueFlag) {
            if(strs[0].length() <= dig)
                break;
            
            char c = strs[0].charAt(dig);
            for(int k = 1; k < strs.length; k++) {
                
                if(strs[k].length() <= dig || strs[k].charAt(dig) != c) {
                    continueFlag = false;
                    break;
                }
            }
            
            if(!continueFlag)
                break;
            
            ret += c;
            dig++;
        }
        
        return ret;
    }
}
