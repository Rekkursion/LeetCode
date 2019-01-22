// 409. Longest Palindrome
// Accepted 7ms

class Solution {
    public int longestPalindrome(String s) {
        int[] alphas = new int[52];
        int ret = 0;
        boolean hasOdd = false;
        
        for(int k = 0; k < s.length(); ++k) {
            if(Character.isUpperCase(s.charAt(k)))
                ++alphas[s.charAt(k) - 65];
            else if(Character.isLowerCase(s.charAt(k)))
                ++alphas[s.charAt(k) - 71];
        }
        
        for(int k = 0; k < 52; ++k) {
            if((alphas[k] & 1) == 1)
                hasOdd = true;
            ret += ((alphas[k] >>> 1) << 1);
        }
        if(hasOdd)
            ++ret;
        
        return ret;
    }
}
