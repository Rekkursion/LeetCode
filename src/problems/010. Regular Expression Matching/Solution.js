// 10. Regular Expression Matching
// Accepted 100ms

String.prototype.isAsterisk = function(idx) {
    return this.charAt(idx) === '_' || this.isUpperCase(idx);
}

String.prototype.isUpperCase = function(idx) {
    return this.charCodeAt(idx) >= 65 && this.charCodeAt(idx) <= 90;
}

/**
 * @param {string} s
 * @param {string} p
 * @return {boolean}
 */
var isMatch = function(s, p) {
    let pattern = '';
    
    // pre process:
    // the general chars do NO changes
    // the asterisk chars (like a*, u*, .* ...) change into uppercase (like a* -> A, u* -> U)
    // '.*' changes into '_'
    for(let pi = 0; pi < p.length; ++pi) {
        if(pi + 1 < p.length && p.charAt(pi + 1) === '*') {
            pattern += (p.charAt(pi) === '.') ? '_' : p.charAt(pi).toUpperCase();
            ++pi;
        } else {
            pattern += p.charAt(pi);
        }
    }
    p = pattern;
    
    // initialize dp matrix
    let dp = Array(p.length + 1);
    for(let k = 0; k <= p.length; ++k)
        dp[k] = Array(s.length + 1).fill(false);
    dp[0][0] = true;
    
    // dp
    // uppercase alphabets (A-Z) or underline (_) means asterisk symbol
    // lowercase alphabets (a-z) or dot (.) means general symbol
    for(let r = 1; r <= p.length; ++r) {
        // .* or a* or b* ...
        dp[r][0] = p.isAsterisk(r - 1) && dp[r - 1][0];
        
        for(let c = 1; c <= s.length; ++c) {
            // general char
            if(!p.isAsterisk(r - 1))
                dp[r][c] = dp[r - 1][c - 1] && (p.charAt(r - 1) === s.charAt(c - 1) || p.charAt(r - 1) === '.');
            
            // asterisk char
            else {
                // .* or equals, e.g. (a* and a) or (g* and g)
                if(p.charAt(r - 1) === '_' || p.charAt(r - 1).toLowerCase() === s.charAt(c - 1))
                    dp[r][c] = dp[r - 1][c - 1] || dp[r - 1][c] || dp[r][c - 1];
                
                // not equals, e.g. (b* and e) or (j* and x)
                else
                    dp[r][c] = dp[r - 1][c];
            }
        }
    }
    
    return dp[p.length][s.length];
};
