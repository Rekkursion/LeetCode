// 3. Longest Substring Without Repeating Characters
// Accepted 8ms

func lengthOfLongestSubstring(s string) int {
    var maxLen int = 0
    
    for i, _ := range s {
        var used [256]bool
        var curLen int = 0
        
        for _, c := range s[i:] {
            if !used[c] {
                curLen++
                used[c] = true
            } else {
              break
            }
        }
        
        if curLen > maxLen {
            maxLen = curLen
        }
    }
    
    return maxLen
}
