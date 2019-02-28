// 39. Combination Sum
// Accepted 16ms

class Solution {
    private int[] nums;
    private List<List<Integer>> ret;
    
    private void dfs(int idx, int sum, List<Integer> sol, final int TARGET) {
        if(idx == nums.length) {
            if(sum == TARGET) {
                List<Integer> solution = new ArrayList<>(sol);
                ret.add(solution);
            }
            
            return;
        }
        
        if(sum + nums[idx] <= TARGET) {
            sol.add(nums[idx]);
            dfs(idx, sum + nums[idx], sol, TARGET);
            sol.remove(sol.size() - 1);
        }
        dfs(idx + 1, sum, sol, TARGET);
        
        return;
    }
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> sol = new ArrayList<>();
        
        Arrays.sort(candidates);
        nums = candidates;
        
        ret = new ArrayList<>();
        
        dfs(0, 0, sol, target);
        
        return ret;
    }
}
