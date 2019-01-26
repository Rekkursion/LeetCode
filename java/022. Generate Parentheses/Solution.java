// 22. Generate Parentheses
// Accepted 3ms

class Solution {
    private List<String> parens;
    
    private void dfs(int open, int closed, String paren, final int N) {
        if(open < closed || open > N)
            return;
        
        if(open == N && closed == N) {
            parens.add(paren);
            return;
        }
        
        dfs(open + 1, closed, paren + "(", N);
        dfs(open, closed + 1, paren + ")", N);
        
        return;
    }
    
    public List<String> generateParenthesis(int n) {
        parens = new ArrayList<String>();
        dfs(0, 0, "", n);
        
        return parens;
    }
}
