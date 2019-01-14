// 7. Reverse Integer
// Accepted 42ms

class Solution {
    public int reverse(int x) {
        long rx = 0L;
        ArrayList<Integer> seq = new ArrayList<Integer>();
        boolean isNegative = (x < 0);
        
        if(isNegative)
            x *= -1;
        
        while(x > 0) {
            seq.add(x % 10);
            x /= 10;
        }
        
        for(Integer i: seq) {
            rx = (rx * 10L) + (long)i;
        }
        
        if(isNegative)
            rx *= -1L;
        
        if(rx < (long)Integer.MIN_VALUE || rx > (long)Integer.MAX_VALUE)
            rx = 0L;
        
        return (int)rx;
    }
}
