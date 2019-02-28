// 282. Expression Add Operators
// Accepted 1395ms

// O(N * 4^N)
class Solution {
    private List<String> ret;
    
    private void dfs(int idx, String ops, final String NUM, final int TARGET) {
        ops += String.valueOf(NUM.charAt(idx));
        
        if(idx == NUM.length() - 1) {
            List<Object> express = new ArrayList();
            Stack<Long> intStk = new Stack();
            Stack<Character> chrStk = new Stack();
            char c, op;
            long sum, a, b;
            
            for(int k = 0; k < ops.length(); ++k) {
                c = ops.charAt(k);
                
                if(c >= '0' && c <= '9') {
                    if(c == '0' && k + 1 < ops.length() && ops.charAt(k + 1) >= '0' && ops.charAt(k + 1) <= '9')
                        return;
                    
                    sum = 0;
                    while(k < ops.length() && ops.charAt(k) >= '0' && ops.charAt(k) <= '9') {
                        sum = (sum * 10L) + (long)(ops.charAt(k) - '0');
                        k++;
                    }
                    k--;
                    
                    express.add(sum);
                }
                
                else
                    express.add(c);
            }
            
            for(int k = 0; k < express.size(); k++) {
                if(express.get(k) instanceof Long)
                    intStk.push((Long)express.get(k));
                
                else {
                    while(!chrStk.empty()) {
                        if((Character)express.get(k) == '*' && chrStk.peek() != '*')
                            break;
                        
                        a = intStk.pop();
                        b = intStk.pop();
                        op = chrStk.pop();
                        
                        if(op == '+')
                            intStk.push(b + a);
                        else if(op == '-')
                            intStk.push(b - a);
                        else
                            intStk.push(b * a);
                    }
                    
                    chrStk.push((Character)express.get(k));
                }
            }
            
            while(!chrStk.empty()) {
                a = intStk.pop();
                b = intStk.pop();
                op = chrStk.pop();
                        
                if(op == '+')
                    intStk.push(b + a);
                else if(op == '-')
                    intStk.push(b - a);
                else
                    intStk.push(b * a);
            }
            
            sum = 0L;
            if(!intStk.empty())
                sum = intStk.pop();
            
            if(sum == (long)TARGET)
                ret.add(ops);
            
            return;
        }
        
        dfs(idx + 1, ops, NUM, TARGET);
        dfs(idx + 1, ops + "+", NUM, TARGET);
        dfs(idx + 1, ops + "-", NUM, TARGET);
        dfs(idx + 1, ops + "*", NUM, TARGET);
        
        return;
    }
    
    public List<String> addOperators(String num, int target) {
        ret = new ArrayList<String>();
        
        if(num.equals(""))
            return ret;
        
        dfs(0, "", num, target);
        
        return ret;
    }
}
