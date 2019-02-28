// 46. Permutations
// Accepted 4ms

class Solution {
    private void dfs(int idx, List<Integer> row, List<List<Integer>> ret, boolean[] used, final int[] NUMS) {
        if(idx == NUMS.length) {
            ret.add(new ArrayList<Integer>(row));
            return;
        }
        
        for(int k = 0; k < NUMS.length; k++) {
            if(!used[k]) {
                row.add(NUMS[k]);
                used[k] = true;
                
                dfs(idx + 1, row, ret, used, NUMS);
                
                row.remove(row.size() - 1);
                used[k] = false;
            }
        }
    }
    
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> row = new ArrayList<>();
        List<List<Integer>> ret = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        
        dfs(0, row, ret, used, nums);
        
        return ret;
    }
}
