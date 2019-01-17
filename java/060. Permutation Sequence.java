// 60. Permutation Sequence
// Accepted 13ms

// O(N^2)
class Solution {
    public String getPermutation(int n, int k) {
        int[] permuNum = new int[n + 1];
        boolean[] used = new boolean[n + 1];
        String ret = "";
        int group = 0, got = 0;
        
        permuNum[0] = 1;
        for(int i = 1; i <= n; ++i)
            permuNum[i] = permuNum[i - 1] * i;
        
        for(int i = n - 1; i >= 0; --i) {
            group = (int)Math.ceil((double)k / (double)permuNum[i]);
            got = 0;
            
            for(int j = 1; j <= n; j++) {
                if(!used[j])
                    got++;
                
                if(got == group) {
                    used[j] = true;
                    k -= (got - 1) * permuNum[i];
                    ret += String.valueOf(j);
                    
                    break;
                }
            }
        }
        
        return ret;
    }
}
