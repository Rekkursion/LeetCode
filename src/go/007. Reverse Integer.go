// 7. Reverse Integer
// Accepted 4ms

func reverse(x int) int {
    var (
        num int64 = int64(x)
        isNeg bool
        reversed []int = make([]int, 0)
    )
    
    if num < 0 { isNeg = true; num = -num } else { isNeg = false }
    
    for num > 0 {
        reversed = append(reversed, int(num % 10))
        num /= 10
    }
    
    num = 0
    for _, val := range reversed { num = (num * 10) + int64(val) }
    
    if isNeg { num = -num }
    if num < int64(math.MinInt32) || num > int64(math.MaxInt32) { num = 0 }
    
    return int(num)
}
