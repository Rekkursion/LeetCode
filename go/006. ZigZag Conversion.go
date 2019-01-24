// 6. ZigZag Conversion
// Accepted 16ms

func convert(s string, numRows int) string {
    if numRows == 1 { return s }
    
    var ret string = ""
    var zigzag []string = make([]string, numRows)
    
    for i := 0; i < numRows; i++ { zigzag[i] = "" }
    
    for i, c := range s {
        var modded_i int = i % ((numRows << 1) - 2)
        if modded_i < numRows {
            zigzag[modded_i] += string(c)
        } else {
            zigzag[((numRows << 1) - 2) - modded_i] += string(c)
        }
    }
    
    for _, str := range zigzag {
        ret += str
    }
    
    return ret
}
