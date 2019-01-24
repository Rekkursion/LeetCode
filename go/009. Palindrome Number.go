// 9. Palindrome Number
// Accepted 76ms

func isPalindrome(x int) bool {
    if x == 0 { return true }
    if x < 0 || x % 10 == 0 { return false }
    
    var intArr []int = make([]int, 0)
    var p, q, intArrLen int
    var isPalinNum bool = true
    
    for x > 0 {
        intArr = append(intArr, x % 10)
        x /= 10
    }
    intArrLen = len(intArr)
    fmt.Println(intArrLen)
    
    if (intArrLen & 1) == 1 {
        q = (intArrLen >> 1)
        p = q
    } else {
        q = (intArrLen >> 1)
        p = (intArrLen >> 1) - 1
    }
    
    for p >= 0 {
        if intArr[p] != intArr[q] {
            isPalinNum = false
            break
        }
        
        p--; q++
    }
    
    return isPalinNum
}
