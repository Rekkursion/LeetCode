// 953. Verifying an Alien Dictionary
// Accepted 7ms

class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] prio = new int[26];
        String x, y;
        int len;
        char cx, cy;
        boolean equal;
        
        int priority = 26;
        for(int k = 0; k < 26; k++)
            prio[order.charAt(k) - 'a'] = priority--;
        
        for(int k = 0; k < words.length - 1; k++) {
            x = words[k];
            y = words[k + 1];
            len = (x.length() < y.length()) ? x.length() : y.length();
            equal = true;
            
            for(int j = 0; j < len; j++) {
                cx = x.charAt(j);
                cy = y.charAt(j);
                
                if(prio[cx - 'a'] < prio[cy - 'a'])
                    return false;
                
                else if(prio[cx - 'a'] > prio[cy - 'a']) {
                    equal = false;
                    break;
                }
            }
            
            if(equal) {
                if(x.length() > y.length())
                    return false;
            }
        }
        
        return true;
    }
}
