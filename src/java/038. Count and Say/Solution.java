// 38. Count and Say
// Accepted 20ms

class Solution {
    public String countAndSay(int n) {
        String seq = "1", nextSeq;
        char num;
        int counter;
        
        for(int k = 2; k <= n; k++) {
            num = seq.charAt(0);
            counter = 1;
            nextSeq = "";
            
            for(int j = 1; j < seq.length(); j++) {
                if(seq.charAt(j) == num)
                    counter++;
                else {
                    nextSeq += String.valueOf(counter) + String.valueOf(num);
                    counter = 1;
                    num = seq.charAt(j);
                }
            }
            nextSeq += String.valueOf(counter) + String.valueOf(num);
            
            seq = nextSeq;
        }
        
        return seq;
    }
}
