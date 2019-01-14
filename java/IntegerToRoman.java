// 12. Integer to Roman
// Accepted 86ms

class Solution {
    public String intToRoman(int num) {
        String[] M =  {"", "M", "MM", "MMM"};
        String[] CM = {"", "CM"};
        String[] D =  {"", "D"};
        String[] CD = {"", "CD"};
        String[] C =  {"", "C", "CC", "CCC"};
        String[] XC = {"", "XC"};
        String[] L =  {"", "L"};
        String[] XL = {"", "XL"};
        String[] X =  {"", "X", "XX", "XXX"};
        String[] IX = {"", "IX"};
        String[] V =  {"", "V"};
        String[] IV = {"", "IV"};
        String[] I =  {"", "I", "II", "III"};
        
        
        int m = num / 1000;
        num %= 1000;
        
        int cm = num / 900;
        num %= 900;
        
        int d = num / 500;
        num %= 500;
        
        int cd = num / 400;
        num %= 400;
        
        int c = num / 100;
        num %= 100;
        
        int xc = num / 90;
        num %= 90;
        
        int l = num / 50;
        num %= 50;
        
        int xl = num / 40;
        num %= 40;
        
        int x = num / 10;
        num %= 10;
        
        int ix = num / 9;
        num %= 9;
        
        int v = num / 5;
        num %= 5;
        
        int iv = num / 4;
        num %= 4;
        
        int i = num;
        
        
        return (M[m] + CM[cm] + D[d] + CD[cd] + C[c] + XC[xc] + L[l] + XL[xl] + X[x] + IX[ix] + V[v] + IV[iv] + I[i]);
    }
}
