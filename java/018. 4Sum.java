// 18. 4Sum
// Accepted 1448ms

class Solution {
    private boolean canUse(int idx, boolean[] used, final int[] NUMS) {
        if(used[idx])
            return false;
        if(idx == 0 || NUMS[idx] != NUMS[idx - 1])
            return true;
        return (used[idx - 1]);
    }
    
    private void dfs(int idx, int sum, int usedNum, List<Integer> row, List<List<Integer>> ret, boolean[] used, final int[] NUMS, final int TARGET) {
        if(usedNum == 4) {
            if(sum == TARGET)
                ret.add(new ArrayList<Integer>(row));
            
            return;
        }
        
        if(idx == NUMS.length)
            return;
        
        if(canUse(idx, used, NUMS) && (NUMS[idx] < 0 || sum + NUMS[idx] <= TARGET)) {
            row.add(NUMS[idx]);
            used[idx] = true;
            dfs(idx + 1, sum + NUMS[idx], usedNum + 1, row, ret, used, NUMS, TARGET);
            row.remove(row.size() - 1);
            used[idx] = false;
        }
        dfs(idx + 1, sum, usedNum, row, ret, used, NUMS, TARGET);
        
        return;
    }
    
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<Integer> row = new ArrayList<>();
        List<List<Integer>> ret = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        
        Arrays.sort(nums);
        dfs(0, 0, 0, row, ret, used, nums, target);
        
        return ret;
    }
}
