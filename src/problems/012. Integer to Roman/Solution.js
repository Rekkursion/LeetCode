// 12. Integer to Roman
// Accepted 160ms

/**
 * @param {number} num
 * @return {string}
 */
var intToRoman = function(num) {
    let symbols = {
        M: 1000, CM: 900, D: 500, CD: 400, C: 100, XC: 90, L: 50, XL: 40, X: 10, IX: 9, V: 5, IV: 4, I: 1
    };
    let ret = '';
    
    for(let key in symbols) {
        let times = Math.floor(num / symbols[key]);
        ret += key.repeat(times);
        num -= symbols[key] * times;
        if(num === 0)
            break;
    }
    
    return ret;
};
