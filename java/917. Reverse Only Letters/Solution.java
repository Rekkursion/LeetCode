// 917. Reverse Only Letters
// Accepted 9ms

class Solution {
    private boolean isAlpha(char c) {
        return ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'));
    }
    
    public String reverseOnlyLetters(String S) {
        char c;
        String ret = "";
        int curIdx = 0;
        
        for(int k = S.length() - 1; k >= 0; k--) {
            c = S.charAt(k);
            
            if(isAlpha(c)) {
                while(curIdx < S.length() && !isAlpha(S.charAt(curIdx))) {
                    ret += S.charAt(curIdx);
                    curIdx++;
                }
                
                ret += c;
                curIdx++;
            }
        }
        
        while(curIdx < S.length()) {
            ret += S.charAt(curIdx);
            curIdx++;
        }
        
        return ret;
    }
}
