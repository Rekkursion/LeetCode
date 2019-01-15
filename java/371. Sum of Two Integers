// 371. Sum of Two Integers
// Accepted 0ms

class Solution {
    public int getSum(int a, int b) {
        int ret = 0;
        int carry = 0;
        for(int k = 0; k < 32; k++) {
            ret = (ret | ((a & (1 << k)) ^ (b & (1 << k)) ^ (carry << k)));
            carry = ((((a >> k) & 1) & ((b >> k) & 1)) | (((b >> k) & 1) & carry) | (carry & ((a >> k) & 1)));
        }
        
        return ret;
    }
}
