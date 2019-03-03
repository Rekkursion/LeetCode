// 9. Palindrome Number
// Accepted 248ms

/**
 * @param {number} x
 * @return {boolean}
 */
var isPalindrome = function(x) {
    if((!x && x !== 0) || x < 0 || (x !== 0 && x % 10 === 0))
        return false;
    if(x === 0)
        return true;
    
    let rev = 0;
    while(rev < x) {
        rev = (rev * 10) + (x % 10);
        x = Math.floor(x / 10);
    }
    
    return rev === x || Math.floor(rev / 10) === x;
};
