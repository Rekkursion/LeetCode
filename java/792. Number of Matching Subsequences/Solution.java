// 792. Number of Matching Subsequences
// Accepted 5724ms

class Solution {
    public int numMatchingSubseq(String S, String[] words) {
        if(S.length() == 0 || words.length == 0)
            return 0;
        
        int[] waitingIdx = new int[words.length];
        int ret = 0;
        
        Arrays.fill(waitingIdx, 0);
        
        for(int k = 0; k < S.length(); ++k) {
            for(int j = 0; j < words.length; ++j) {
                if(waitingIdx[j] < words[j].length() && S.charAt(k) == words[j].charAt(waitingIdx[j]))
                    ++waitingIdx[j];
            }
        }
        
        for(int j = 0; j < words.length; ++j) {
            if(waitingIdx[j] == words[j].length())
                ++ret;
        }
        
        return ret;
    }
}
