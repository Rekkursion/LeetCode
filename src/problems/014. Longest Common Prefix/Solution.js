// 14. Longest Common Prefix
// Accepted 64ms

/**
 * @param {string[]} strs
 * @return {string}
 */
var longestCommonPrefix = function(strs) {
    if(strs.length === 0)
        return "";
    let k = 0, endFlag = false;
    
    while(!endFlag) {
        let char = strs[0].charAt(k);
        for(let str of strs) {
            if(k >= str.length || str.charAt(k) !== char) {
                endFlag = true;
                break;
            }
        }
        ++k;
    }
    
    return strs[0].slice(0, k - 1);
};
