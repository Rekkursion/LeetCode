// 13. Roman to Integer
// Accepted 172ms

/**
 * @param {string} s
 * @return {number}
 */
var romanToInt = function(s) {
    let [ret, sLen] = [0, s.length];
    let symbols = new Map([['M', 1000], ['D', 500], ['C', 100], ['L', 50], ['X', 10], ['V', 5], ['I', 1]]);
    
    for(let k = 0; k < sLen; ++k) {
        if(k + 1 < sLen && symbols.get(s.charAt(k + 1)) > symbols.get(s.charAt(k))) {
            ret += symbols.get(s.charAt(k + 1)) - symbols.get(s.charAt(k));
            ++k;
        } else {
            ret += symbols.get(s.charAt(k));
        }
    }
    
    return ret;
};
