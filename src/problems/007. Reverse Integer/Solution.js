// 7. Reverse Integer
// Accepted 92ms

/**
 * @param {number} x
 * @return {number}
 */
var reverse = function(x) {
    const INT32_MAX = 2147483647;
    const INT32_MIN = -2147483648;
    let ret = 0;
    let isNegative = false;
    
    if(x < 0) {
        x = -x;
        isNegative = true;
    }
    
    while(x > 0) {
        ret = (ret * 10) + (x % 10);
        x = parseInt(Math.floor(x / 10));
    }
    
    if(isNegative)
        ret = -ret;
    if(ret > INT32_MAX || ret < INT32_MIN)
        ret = 0;
    
    return ret;
};
