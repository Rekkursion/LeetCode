// 67. Add Binary
// Accepted 1ms

class Solution {
    public String addBinary(String a, String b) {
        int lenA = a.length();
        int lenB = b.length();
        int carry = 0;
        StringBuilder sBuf = new StringBuilder();
        
        for(int k = lenA - 1, j = lenB - 1; k >= 0 || j >= 0 || carry != 0; --k, --j) {
            int ia = (k < 0) ? 0 : (a.charAt(k) - 48);
            int ib = (j < 0) ? 0 : (b.charAt(j) - 48);
            sBuf.append(ia ^ ib ^ carry);
            carry = ((ia & ib) | (ia & carry) | (ib & carry));
        }
        
        return sBuf.reverse().toString();
    }
}
