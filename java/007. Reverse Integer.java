// 7. Reverse Integer
// Accepted 28ms

class Solution {
    public int reverse(int x) {
        long rx = 0L;
        boolean isNegative = (x < 0);
        
        if(isNegative)
            x *= -1;
        
        while(x > 0) {
            rx = (rx * 10L) + (x % 10);
            x /= 10;
        }
        
        if(isNegative)
            rx *= -1L;
        
        if(rx < Integer.MIN_VALUE || rx > Integer.MAX_VALUE)
            rx = 0L;
        
        return (int)rx;
    }
}
