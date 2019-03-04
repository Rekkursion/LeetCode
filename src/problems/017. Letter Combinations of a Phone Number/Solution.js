// 17. Letter Combinations of a Phone Number
// Accepted 56ms

let letters = Array.of('', '', 'abc', 'def', 'ghi', 'jkl', 'mno', 'pqrs', 'tuv', 'wxyz');

let dfs = function(digIdx, str, ret, digits) {
    if(digIdx === digits.length) {
        ret.push(str);
        return;
    }
    
    let lettersIdx = digits.charCodeAt(digIdx) - 48;
    for(let k = 0; k < letters[lettersIdx].length; ++k)
        dfs(digIdx + 1, str + letters[lettersIdx].charAt(k), ret, digits);
    
    return;
}

/**
 * @param {string} digits
 * @return {string[]}
 */
var letterCombinations = function(digits) {
    if(!digits)
        return [];
    
    let ret = Array();
    dfs(0, '', ret, digits);
    
    return ret;
};
