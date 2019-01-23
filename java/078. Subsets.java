// 78. Subsets
// Accepted 1ms

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int goal = (1 << nums.length);
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> row = new ArrayList<>();
        
        for(int cur = 0; cur < goal; ++cur) {
            row.clear();
            for(int pos = 0; pos < nums.length; ++pos) {
                if(((1 << pos) & cur) != 0)
                    row.add(nums[pos]);
            }
            ret.add(new ArrayList<Integer>(row));
        }
        
        return ret;
    }
}
