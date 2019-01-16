// 40. Combination Sum II
// Accepted 18ms

class Solution {
    private int[] nums;
    private List<List<Integer>> ret;
    
    private boolean canUse(final int IDX, final boolean[] USED) {
        if(IDX == 0 || nums[IDX] != nums[IDX - 1])
            return true;
        
        return USED[IDX - 1];
    }
    
    private void dfs(int idx, int sum, List<Integer> sol, boolean[] used, final int TARGET) {
        if(idx == nums.length) {
            if(sum == TARGET) {
                List<Integer> solution = new ArrayList<>(sol);
                ret.add(solution);
            }
            
            return;
        }
        
        if(sum + nums[idx] <= TARGET && canUse(idx, used)) {
            sol.add(nums[idx]);
            used[idx] = true;
            
            dfs(idx + 1, sum + nums[idx], sol, used, TARGET);
            
            sol.remove(sol.size() - 1);
            used[idx] = false;
        }
        dfs(idx + 1, sum, sol, used, TARGET);
        
        return;
    }
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> sol = new ArrayList<>();
        boolean[] used = new boolean[candidates.length];
        
        Arrays.sort(candidates);
        nums = candidates;
        
        ret = new ArrayList<>();
        
        dfs(0, 0, sol, used, target);
        
        return ret;
    }
}
