// 792. Number of Matching Subsequences
// Accepted 3424ms

func numMatchingSubseq(S string, words []string) int {
    if len(S) == 0 || len(words) == 0 { return 0 }
    
    var (
        wordsLen int = len(words)
        waitingIdx []int = make([]int, 0)
        ret int = 0
    )
    
    for i := 0; i < wordsLen; i++ { waitingIdx = append(waitingIdx, 0) }
    for _, c := range S {
        for i := 0; i < wordsLen; i++ {
            if waitingIdx[i] < len(words[i]) && words[i][waitingIdx[i]] == byte(c) {
                waitingIdx[i]++;
            }
        }
    }
    
    for i, val := range waitingIdx {
        if val == len(words[i]) { ret++ }
    }
    
    return ret
}
