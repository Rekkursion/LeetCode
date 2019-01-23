// 90. Subsets II
// Accepted 47ms

class Solution {
    private boolean canUse(int cur, int pos, final int[] nums) {
        if(((1 << pos) & cur) == 0)
            return false;
        if(pos == nums.length - 1 || nums[nums.length - (pos + 1)] != nums[nums.length - (pos + 2)])
            return true;
        return (((1 << (pos + 1)) & cur) != 0);
    }
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        int goal = (1 << nums.length);
        Set<List<Integer>> ret = new HashSet<>();
        List<Integer> row = new ArrayList<>();
        int bit;
        boolean[] usedBit = new boolean[goal];
        
        Arrays.sort(nums);
        
        for(int cur = 0; cur < goal; ++cur) {
            row.clear();
            bit = 0;
            for(int pos = nums.length - 1; pos >= 0; --pos) {
                if(canUse(cur, pos, nums)) {
                    bit |= (1 << pos);
                    row.add(nums[nums.length - (pos + 1)]);
                }
            }
            
            if(!usedBit[bit]) {
                ret.add(new ArrayList<Integer>(row));
                usedBit[bit] = true;
            }
        }
        
        return ret.stream().collect(Collectors.toList());
    }
}
