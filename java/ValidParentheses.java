// 20. Valid Parentheses
// Accepted 8ms

class Solution {
    public boolean isValid(String s) {
        List<Character> stk = new ArrayList<Character>();
        char c;
        
        for(int k = 0; k < s.length(); k++) {
            c = s.charAt(k);
            
            if(c == '(' || c == '[' || c == '{')
                stk.add(c);
            else {
                if(c == ')' && (stk.size() == 0 || stk.get(stk.size() - 1) != '('))
                    return false;
                if(c == ']' && (stk.size() == 0 || stk.get(stk.size() - 1) != '['))
                    return false;
                if(c == '}' && (stk.size() == 0 || stk.get(stk.size() - 1) != '{'))
                    return false;
                
                stk.remove(stk.size() - 1);
            }
        }
        
        return (stk.size() == 0);
    }
}
