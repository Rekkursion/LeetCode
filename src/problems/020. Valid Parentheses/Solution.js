// 20. Valid Parentheses
// Accepted 56ms

/**
 * @param {string} s
 * @return {boolean}
 */
var isValid = function(s) {
    let stack = Array();
    let sLen = s.length;
    
    for(let k = 0; k < sLen; ++k) {
        let ch = s.charAt(k);
        if(ch === '(' || ch === '{' || ch === '[')
            stack.push(ch);
        else {
            let stackTopChar = stack.pop();
            if(!((stackTopChar === '(' && ch === ')') || (stackTopChar === '{' && ch === '}') || (stackTopChar === '[' && ch === ']')))
                return false;
        }
    }
    
    return !stack.length;
};
