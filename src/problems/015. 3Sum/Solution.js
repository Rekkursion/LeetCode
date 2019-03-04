// 15. 3Sum
// Accepted 1016ms

/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var threeSum = function(nums) {
    // -4, -1, -1, 0, 1, 2
    nums.sort((a, b) => a - b);
    
    let map = new Map();
    let ret = Array();
    
    for(let idx in nums) {
        let [p, q] = [parseInt(idx) + 1, nums.length - 1];
        
        while(p < q) {
            let sum = nums[idx] + nums[p] + nums[q];
            
            if(sum > 0)
                --q;
            else if(sum < 0)
                ++p;
            else {
                map.set(nums[idx].toString() + nums[p].toString() + nums[q].toString(), Array.of(nums[idx], nums[p], nums[q]));
                ++p;
                --q;
            }
        }
    }
    
    for(let [key, val] of map)
        ret.push(val);
    
    return ret;
};
