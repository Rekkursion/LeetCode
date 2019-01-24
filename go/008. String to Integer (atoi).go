// 8. String to Integer (atoi)
// Accepted 4ms

func myAtoi(str string) int {
    str = strings.TrimSpace(str)
    if len(str) == 0 || (str[0] != '+' && str[0] != '-' && (str[0] < '0' || str[0] > '9')) { return 0 }
    
    var (
        num int64 = 0
        startIdx int = 0
        isNeg = false
    )
    
    switch str[0] {
        case '-': isNeg = true; fallthrough
        case '+': startIdx = 1
    }
    
    for _, c := range str[startIdx:] {
        if c < '0' || c > '9' { break }
        
        num = (num * 10) + int64(c - '0')
        if (isNeg && (-num) < int64(math.MinInt32)) || (!isNeg && num > int64(math.MaxInt32)) { break }
    }
    
    if isNeg { num = -num }
    if num < int64(math.MinInt32) { num = int64(math.MinInt32) }
    if num > int64(math.MaxInt32) { num = int64(math.MaxInt32) }
    
    return int(num)
}
