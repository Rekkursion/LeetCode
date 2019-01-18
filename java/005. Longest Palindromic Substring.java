// 5. Longest Palindromic Substring
// Accepted 65ms

class Solution {
    // Expand Around Center
    public String longestPalindrome(String s) {
        int i, j, palinStart = 0, palinEnd = s.length();
        int maxPalinLen = 0, palinLen;
        
        for(int k = 0; k < s.length(); k++) {
            
            palinLen = 1;
            for(i = k + 1, j = k - 1; i < s.length() && j >= 0; ++i, --j) {
                if(s.charAt(i) != s.charAt(j))
                    break;
                palinLen += 2;
            }
            if(palinLen > maxPalinLen) {
                palinStart = j + 1;
                palinEnd = i;
                maxPalinLen = palinLen;
            }
            
            if(k + 1 < s.length() && s.charAt(k) == s.charAt(k + 1)) {
                palinLen = 2;
                for(i = k + 2, j = k - 1; i < s.length() && j >= 0; ++i, --j) {
                    if(s.charAt(i) != s.charAt(j))
                        break;
                    palinLen += 2;
                }
                if(palinLen > maxPalinLen) {
                    palinStart = j + 1;
                    palinEnd = i;
                    maxPalinLen = palinLen;
                }
            }
        }
        
        return s.substring(palinStart, palinEnd);
    }
}
