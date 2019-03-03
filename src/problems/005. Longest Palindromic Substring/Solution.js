// 5. Longest Palindromic Substring
// Accepted 124ms

// Manacher's Algorithm

function preProcess(s) {
    let sLen = s.length;
    let ret = '^';
    
    for(let k = 0; k < sLen; ++k)
        ret += `#${s.charAt(k)}`;
    ret += '#$';
    
    return ret;
}

/**
 * @param {string} s
 * @return {string}
 */
var longestPalindrome = function(s) {
    if(!s || s.length <= 1)
        return s;
    s = preProcess(s);
    
    let [sLen, centre, right, maxLen] = [s.length, 0, 0, -1];
    let p = Array(sLen).fill(0);
    let ret = '';
    
    for(let k = 1; k < sLen - 1; ++k) {
        p[k] = k < right ? Math.min(p[centre - (k - centre)], right - k) : 0;
        while(s.charAt(k - p[k] - 1) == s.charAt(k + p[k] + 1))
            ++p[k];
        if(k + p[k] > right) {
            centre = k;
            right = p[k];
        }
    }
    
    centre = 0;
    for (let k = 0; k < sLen; ++k) {
        if (p[k] > maxLen) {
            centre = k;
            maxLen = p[k];
        }
    }
    
    for(let k = centre - maxLen; k <= centre + maxLen; ++k) {
        if(s.charAt(k) != '#')
            ret += s.charAt(k);
    }
    
    return ret;
};
