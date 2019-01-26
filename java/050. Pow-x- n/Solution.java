// 50. Pow(x, n)
// Accepted 15ms

class Solution {
    public double myPow(double x, int n) {
        if(x == 0.0)
            return 0.0;
        if(x == 1.0)
            return 1.0;
        if(x == -1.0)
            return ((Math.abs(n) % 2 == 0) ? 1.0 : -1.0);
        if(n == 0)
            return 1.0;
        if(n == 1)
            return x;
        if(n == -1)
            return ((x == 0.0) ? 0.0 : (1.0 / x));
        
        boolean nLessThanZero = (n < 0);
        double ret = 1.0, multisor = x;
        
        n = Math.abs(n);
        
        for(int k = 0; k < 32; k++) {
            if(((n >> k) & 1) == 1)
                ret *= multisor;
            
            multisor *= multisor;
        }
        
        if(nLessThanZero)
            ret = 1.0 / ret;
        
        return ret;
    }
}
