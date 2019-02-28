// 5. Longest Palindromic Substring
// Accepted 8ms

func longestPalindrome(s string) string {
    var ret string = ""
    var sub string = ""
    var sLen int = len(s)
    
    for i, _ := range s {
        sub = s[i:(i + 1)]
        for p, q := i - 1, i + 1; p >= 0 && q < sLen; p, q = p - 1, q + 1 {
            if s[p] != s[q] { break }
            sub = s[p:(q + 1)]
        }
        if(len(sub) > len(ret)) { ret = sub }
        
        if i + 1 < sLen && s[i] == s[i + 1] {
            sub = s[i:(i + 2)]
            for p, q := i - 1, i + 2; p >= 0 && q < sLen; p, q = p - 1, q + 1 {
                if s[p] != s[q] { break }
                sub = s[p:(q + 1)]
            }
            if(len(sub) > len(ret)) { ret = sub }
        }
    }
    
    return ret
}
