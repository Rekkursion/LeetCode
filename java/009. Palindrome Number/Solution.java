// 9. Palindrome Number
// Accepted 182ms

class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        
        String l2r = String.valueOf(x);
        String r2l = "";
        
        while(x > 0) {
            r2l += String.valueOf(x % 10);
            x /= 10;
        }
        if(r2l == "")
            r2l = "0";
        
        return l2r.equals(r2l);
    }
}
