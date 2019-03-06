// 22. Generate Parentheses
// Accepted 60ms

let gen = function(openedNum, closedNum, row, ret, N) {
    if(openedNum === closedNum && openedNum === N) {
        ret.push(row);
        return;
    }
    
    if(openedNum < N)
        gen(openedNum + 1, closedNum, row + '(', ret, N);
    if(openedNum > closedNum)
        gen(openedNum, closedNum + 1, row + ')', ret, N);
    
    return;
}

/**
 * @param {number} n
 * @return {string[]}
 */
var generateParenthesis = function(n) {
    if(!n || n < 0)
        return [''];
    
    let ret = Array();
    let row = '';
    
    gen(0, 0, row, ret, n);
    return ret;
};
