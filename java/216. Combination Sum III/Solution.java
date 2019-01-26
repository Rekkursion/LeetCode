// 216. Combination Sum III
// Accepted 1ms

class Solution {
    private void dfs(int num, int sum, int solSize, List<Integer> sol, List<List<Integer>> ret, final int K, final int TARGET) {
        if(solSize == K) {
            if(sum == TARGET) {
                List<Integer> solution = new ArrayList<>(sol);
                ret.add(solution);
            }
            
            return;
        }
        
        if(num == 10)
            return;
        
        if(sum + num <= TARGET) {
            sol.add(num);
            dfs(num + 1, sum + num, solSize + 1, sol, ret, K, TARGET);
            sol.remove(sol.size() - 1);
        }
        dfs(num + 1, sum, solSize, sol, ret, K, TARGET);
        
        return;
    }
    
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> sol = new ArrayList<>();
        List<List<Integer>> ret = new ArrayList<>();
        
        dfs(1, 0, 0, sol, ret, k, n);
        
        return ret;
    }
}
