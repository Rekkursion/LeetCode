// 16. 3Sum Closest
// Accepted 72ms

/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var threeSumClosest = function(nums, target) {
    nums.sort((a, b) => a - b);
    
    let closest = 2147483647, gap = 2147483647;
    
    outer_loop:
    for(let idx in nums) {
        let [p, q] = [parseInt(idx) + 1, nums.length - 1];
        
        while(p < q) {
            let sum = nums[idx] + nums[p] + nums[q];
            
            if(Math.abs(sum - target) < gap) {
                closest = sum;
                gap = Math.abs(sum - target);
            }
            
            if(sum < target)
                ++p;
            else if(sum > target)
                --q;
            else {
                closest = target;
                break outer_loop;
            }
        }
    }
    
    return closest;
};
