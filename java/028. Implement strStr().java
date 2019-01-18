// 28. Implement strStr()
// Accepted 15ms

class Solution {
    private void buildPrefix(String pattern, int[] prefix) {
        int len = 0, i = 1;
        
        prefix[0] = 0;
        while(i < pattern.length()) {
            if(pattern.charAt(i) == pattern.charAt(len))
                prefix[i++] = ++len;
            else {
                if(len > 0)
                    len = prefix[len - 1];
                else
                    prefix[i++] = 0;
            }
        }
        
        for(i = prefix.length - 1; i > 0; --i)
            prefix[i] = prefix[i - 1];
        prefix[0] = -1;
        
        return;
    }
    
    private int kmp_search(String text, String pattern) {
        if(pattern == null || text == null || text.length() < pattern.length())
            return -1;
        if(pattern.length() == 0)
            return 0;
        
        int[] prefix = new int[pattern.length()];
        int t = 0, p = 0;
        
        buildPrefix(pattern, prefix);
        
        while(t < text.length()) {
            // Found the pattern
            if(p == pattern.length() - 1 && text.charAt(t) == pattern.charAt(p)) {
                return (t - p);
                
                //p = prefix[p];
                //if(p == -1) { p++; t++; }
            }
            
            if(text.charAt(t) == pattern.charAt(p)) {
                t++;
                p++;
            }
            else {
                p = prefix[p];
                if(p == -1) {
                    p++;
                    t++;
                }
            }
        }
        
        return -1;
    }
    
    public int strStr(String haystack, String needle) {
        return kmp_search(haystack, needle);
    }
}
