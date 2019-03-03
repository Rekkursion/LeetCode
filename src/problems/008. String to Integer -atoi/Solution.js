// 8. String to Integer (atoi)
// Accepted 88ms

String.prototype.leftTrim = function() {
    if(!this)
        return undefined;
    return this.replace(/^\s+/, '');
}

/**
 * @param {string} str
 * @return {number}
 */
var myAtoi = function(str) {
    str = str.leftTrim();
    if(!str || str.length === 0)
        return 0;
    
    const INT32_MAX = 2147483647;
    const INT32_MIN = -2147483648;
    let [isNegative, startIdx, strLen] = [false, 0, str.length];
    let num = 0;
    
    switch(str.charAt(0)) {
        case '+':
            startIdx = 1;
            break;
        case '-':
            isNegative = true;
            startIdx = 1;
            break;
    }
    
    for(let k = startIdx; k < strLen && str.charCodeAt(k) >= 48 && str.charCodeAt(k) <= 57; ++k) {
        num = (num * 10) + (str.charCodeAt(k) - 48);
        if(num > -INT32_MIN)
            break;
    }
    if(isNegative)
        num = -num;
    
    if(num > INT32_MAX)
        num = INT32_MAX;
    if(num < INT32_MIN)
        num = INT32_MIN;
    
    return num;
};
