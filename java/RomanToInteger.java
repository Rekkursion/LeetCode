// 13. Roman to Integer
// Accepted 72ms

class Solution {
    public int romanToInt(String s) {
        // M, CM, D, CD, C, XC, L, XL, X, IX, V, IV, I
        
        char c;
        int curLevel = 1;
        int ret = 0;
        
        for(int k = s.length() - 1; k >= 0; k--) {
            c = s.charAt(k);
            
            if(c == 'I') {
                if(curLevel > 1)
                    ret--;
                else {
                    curLevel = 1;
                    ret++;
                }
            }
            
            else if(c == 'V') {
                curLevel = 2;
                ret += 5;
            }
            
            else if(c == 'X') {
                if(curLevel > 3)
                    ret -= 10;
                else {
                    curLevel = 3;
                    ret += 10;
                }
            }
            
            else if(c == 'L') {
                curLevel = 4;
                ret += 50;
            }
            
            else if(c == 'C') {
                if(curLevel > 5)
                    ret -= 100;
                else {
                    curLevel = 5;
                    ret += 100;
                }
            }
            
            else if(c == 'D') {
                curLevel = 6;
                ret += 500;   
            }
            
            else if(c == 'M') {
                curLevel = 7;
                ret += 1000;   
            }
        }
        
        return ret;
    }
}
