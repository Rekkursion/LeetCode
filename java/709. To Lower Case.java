// 709. To Lower Case
// Accepted 1ms

class Solution {
    public String toLowerCase(String str) {
        String ret = "";
        
        for(int k = 0; k < str.length(); k++)
            ret += (str.charAt(k) >= 'A' && str.charAt(k) <= 'Z') ? (char)((int)str.charAt(k) + 32) : str.charAt(k);
        
        return ret;
    }
}
