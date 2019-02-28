// 77. Combinations
// Accepted 9ms

class Solution {
    private void dfs(int cur, int usedNum, List<Integer> row, List<List<Integer>> ret, final int N, final int K) {
        if(usedNum == K) {
            ret.add(new ArrayList<Integer>(row));
            return;
        }
        if(cur > N)
            return;
        
        row.add(cur);
        dfs(cur + 1, usedNum + 1, row, ret, N, K);
        row.remove(row.size() - 1);
        
        dfs(cur + 1, usedNum, row, ret, N, K);
        
        return;
    }
    
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> row = new ArrayList<>();
        
        dfs(1, 0, row, ret, n, k);
        
        return ret;
    }
}
