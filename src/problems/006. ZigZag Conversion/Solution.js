// 6. ZigZag Conversion
// Accepted 116ms

/**
 * @param {string} s
 * @param {number} numRows
 * @return {string}
 */
var convert = function(s, numRows) {
    if(!s || numRows === 1)
        return s;
    
    let mat = Array(numRows).fill('');
    let sLen = s.length;
    let modulo = numRows + (numRows - 2);
    
    for(let k = 0; k < sLen; ++k) {
        let remainder = k % modulo;
        if(remainder < numRows)
            mat[remainder] += s.charAt(k);
        else
            mat[modulo - remainder] += s.charAt(k);
    }
    
    return mat.join('');
};
