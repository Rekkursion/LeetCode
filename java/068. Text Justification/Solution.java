// 68. Text Justification
// Accepted 5ms

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int k = 0, curLen = 0, lastEndIdx = 0, onlyStrLen = 0, spaceLen = 0, strNum = 0, spaceNum = 0;
        String row = "";
        List<String> ret = new ArrayList<>();
        
        for(k = 0; k < words.length; ++k) {
            if(curLen == 0) {
                onlyStrLen = words[k].length();
                curLen = words[k].length();
            }
            else {
                if(curLen + words[k].length() + 1 <= maxWidth) {
                    onlyStrLen += words[k].length();
                    curLen += words[k].length() + 1;
                }
                else {
                    strNum = k - lastEndIdx;
                    spaceNum = (strNum == 1) ? 1 : (strNum - 1);
                    spaceLen = maxWidth - onlyStrLen;
                    row = "";
                    
                    int[] spacePerLen = new int[spaceNum];
                    for(int i = 0; spaceLen > 0; ++i) {
                        if(i == spaceNum)
                            i = 0;
                        
                        spaceLen--;
                        spacePerLen[i]++;
                    }
                    
                    System.out.println(curLen + ", " + onlyStrLen);
                    
                    for(int i = lastEndIdx; i < k; ++i) {
                        row += words[i];
                        
                        for(int sp = 0; row.length() < maxWidth && sp < spacePerLen[i - lastEndIdx]; sp++)
                            row += " ";
                    }
                    
                    curLen = 0;
                    lastEndIdx = k;
                    k--;
                    
                    ret.add(row);
                }
            }
        } // End of for
        
        // Last line
        row = "";
        for(int i = lastEndIdx; i < k; i++)
            row += words[i] + ((i == k - 1) ? "" : " ");
        while(row.length() < maxWidth)
            row += " ";
        
        ret.add(row);
        
        return ret;
    }
}
