// 41. First Missing Positive
// Accepted 60ms

/**
 * @param {number[]} nums
 * @return {number}
 */
var firstMissingPositive = function(nums) {
    let numsLen = nums.length;
    let isEmerge = Array(numsLen + 1).fill(false);
    
    for(let num of nums) {
        if(num > 0 && num <= numsLen)
            isEmerge[num] = true;
    }
    
    for(let idx in isEmerge) {
        if(!isEmerge[idx] && idx > 0)
            return idx;
    }
    return numsLen + 1;
};
