// 47. Permutations II
// Accepted 5ms

class Solution {
    private boolean canUse(int k, boolean[] used, final int[] NUMS) {
        if(used[k])
            return false;
        
        if(k == 0 || NUMS[k] != NUMS[k - 1])
            return true;
        
        return (used[k - 1]);
    }
    
    private void dfs(int idx, List<Integer> row, List<List<Integer>> ret, boolean[] used, final int[] NUMS) {
        if(idx == NUMS.length) {
            if(row.size() > 0)
                ret.add(new ArrayList<Integer>(row));
            return;
        }
        
        for(int k = 0; k < NUMS.length; k++) {
            if(canUse(k, used, NUMS)) {
                used[k] = true;
                row.add(NUMS[k]);
                
                dfs(idx + 1, row, ret, used, NUMS);
                
                used[k] = false;
                row.remove(row.size() - 1);
            }
        }
        
        return;
    }
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> row = new ArrayList<>();
        List<List<Integer>> ret = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        
        Arrays.sort(nums);
        dfs(0, row, ret, used, nums);
        
        return ret;
    }
}
