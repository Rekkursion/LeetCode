// 16. 3Sum Closest
// Accepted 10ms

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int p, q;
        int sum, ret = 0, minGap = Integer.MAX_VALUE;
        boolean first = true;
        
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; ++i) {
            p = i + 1;
            q = nums.length - 1;
            
            while(p < q) {
                sum = nums[i] + nums[p] + nums[q];
                if(sum > target)
                    q--;
                else if(sum < target)
                    p++;
                else
                    return sum;
                
                if(first) {
                    ret = sum;
                    minGap = Math.abs(sum - target);
                    first = false;
                }
                else {
                    if(Math.abs(sum - target) < minGap) {
                        ret = sum;
                        minGap = Math.abs(sum - target);
                    }
                }
            }
        }
        
        return ret;
    }
}
