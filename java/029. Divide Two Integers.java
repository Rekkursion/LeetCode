// 29. Divide Two Integers
// 29ms

class Solution {
    public int divide(int dividend, int divisor) {
        boolean isNegative = false;
        long dend, dsor, quot, minusor, increment;
        
        if((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0))
            isNegative = true;
        
        dend = (long)Math.abs((long)dividend);
        dsor = (long)Math.abs((long)divisor);
        
        if(dend < dsor)
            return 0;
        
        if(dsor == 0L)
            return Integer.MAX_VALUE;
        
        minusor = dsor;
        quot = 0L;
        increment = 1L;
        while(dend >= dsor) {
            quot += increment;
            dend -= minusor;
            
            minusor += minusor;
            increment += increment;
            if(minusor > dend) {
                minusor = dsor;
                increment = 1L;
            }
        }
        
        if(isNegative)
            quot = -quot;
        
        if(quot < Integer.MIN_VALUE || quot > Integer.MAX_VALUE)
            quot = (long)Integer.MAX_VALUE;
        
        return (int)quot;
    }
}
