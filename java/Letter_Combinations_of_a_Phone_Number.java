// 17. Letter Combinations of a Phone Number
// Accepted 3ms

class Solution {
    private final String[][] letters = {{""},
                                        {""},
                                        {"a", "b", "c"},
                                        {"d", "e", "f"},
                                        {"g", "h", "i"},
                                        {"j", "k", "l"},
                                        {"m", "n", "o"},
                                        {"p", "q", "r", "s"},
                                        {"t", "u", "v"},
                                        {"w", "x", "y", "z"}};
    
    private List<String> ret = new ArrayList<String>();
    
    private void dfs(int digIdx, String str, final String digits) {
        if(digIdx >= digits.length()) {
            if(str != "")
                ret.add(str);
            
            return;
        }
        
        int number = digits.charAt(digIdx) - '0';
        
        for(int k = 0; k < letters[number].length; k++)
            dfs(digIdx + 1, str + letters[number][k], digits);
        
        return;
    }
    
    public List<String> letterCombinations(String digits) {
        dfs(0, "", digits);
        return ret;
    }
}
