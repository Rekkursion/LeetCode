// 504. Base 7
// Accepted 14ms

class Solution {
    public String convertToBase7(int num) {
        if(num == 0)
            return "0";
        
        StringBuffer sBuf = new StringBuffer();
        boolean isNegative = (num < 0);
        
        while(num != 0) {
            sBuf.append(Math.abs(num % 7));
            num /= 7;
        }
        
        return (isNegative ? "-" : "") + sBuf.reverse().toString();
    }
}
