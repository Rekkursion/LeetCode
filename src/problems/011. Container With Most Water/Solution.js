// 11. Container With Most Water
// Accepted 60ms

/**
 * @param {number[]} height
 * @return {number}
 */
var maxArea = function(height) {
    let hNum = height.length;
    let maxWater = 0;
    
    for(let k = 0, j = hNum - 1; k < j; ) {
        if(height[k] < height[j]) {
            maxWater = Math.max(height[k] * (j - k), maxWater);
            ++k;
        } else {
            maxWater = Math.max(height[j] * (j - k), maxWater);
            --j;
        }
    }
    
    return maxWater;
};
