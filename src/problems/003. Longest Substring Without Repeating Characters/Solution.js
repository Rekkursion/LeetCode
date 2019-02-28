// 3. Longest Substring Without Repeating Characters
// Accepted 148ms

/**
 * @param {string} s
 * @return {number}
 */
var lengthOfLongestSubstring = function(s) {
    let sLen = s.length;
    let maxLen = 0;
    
    for(let k = 0; k < sLen; ++k) {
        let used = Array(256).fill(false);
        let curLen = 0;
        
        for(let j = k; j < sLen; ++j) {
            if(used[s.charCodeAt(j)] == false)
                used[s.charCodeAt(j)] = true;
            else
                break;
            ++curLen;
        }
        
        if(curLen > maxLen)
            maxLen = curLen;
    }
    
    return maxLen;
};
