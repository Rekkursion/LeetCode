// 1. Two Sum
// Accepted 108ms

/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(nums, target) {
    let leftIdx = 0;
    let rightIdx = 0;
    
    outer_loop:
    for(let k = 0; k < nums.length; ++k) {
        for(let j = k + 1; j < nums.length; ++j) {
            if(nums[k] + nums[j] == target) {
                leftIdx = k;
                rightIdx = j;
                break outer_loop;
            }
        }
    }
    
    return [leftIdx, rightIdx];
};
