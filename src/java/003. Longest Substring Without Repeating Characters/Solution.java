// 3. Longest Substring Without Repeating Characters
// Accepted 37ms

class Solution {
    public int lengthOfLongestSubstring(String s) {
        boolean[] usedChar = new boolean[256];
        int len, maxLen;
        
        maxLen = 0;
        for(int k = 0; k < s.length(); k++) {
            for(int j = 0; j < 256; j++)
                usedChar[j] = false;
            
            len = 0;
            for(int j = k; j < s.length(); j++) {
                if(usedChar[(int)s.charAt(j)] == false) {
                    len++;
                    usedChar[(int)s.charAt(j)] = true;
                }
                else
                    break;
            }
            if(len > maxLen)
                maxLen = len;
        }
        
        return maxLen;
    }
}
