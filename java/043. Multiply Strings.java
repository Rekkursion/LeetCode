// 43. Multiply Strings
// Accepted 27ms

class Solution {
    public String multiply(String num1, String num2) {
        int len1 = num1.length(), len2 = num2.length();
        int product, i, offset;
        int[] reversed = new int[len1 + len2];
        StringBuffer sBuf;
        
        if(len1 == 0 || len2 == 0 || num1.equals("0") || num2.equals("0"))
            return "0";
        
        offset = i = 0;
        for(int k = len1 - 1; k >= 0; --k, ++offset) {
            i = offset;
            for(int j = len2 - 1; j >= 0; --j, ++i) {
                product = (int)(num1.charAt(k) - '0') * (int)(num2.charAt(j) - '0');
                reversed[i] += product % 10;
                reversed[i + 1] += product / 10;
                
                if(reversed[i] >= 10) {
                    reversed[i + 1] += reversed[i] / 10;
                    reversed[i] %= 10;
                }
            }
        }
        
        sBuf = new StringBuffer();
        for(i = (reversed[i] == 0) ? i - 1 : i; i >= 0; i--)
            sBuf.append(reversed[i]);
        
        return sBuf.toString();
    }
}
