// 224. Basic Calculator
// Accepted 80ms

class Solution {
    public int calculate(String s) {
        int sum, a, b;
        char c, op;
        Stack<Integer> numStk = new Stack<Integer>();
        Stack<Character> opStk = new Stack<Character>();
        
        for(int k = 0; k < s.length(); k++) {
            c = s.charAt(k);
            
            if(c >= '0' && c <= '9') {
                sum = 0;
                while(k < s.length() && ((s.charAt(k) >= '0' && s.charAt(k) <= '9') || s.charAt(k) == ' ')) {
                    if(s.charAt(k) >= '0' && s.charAt(k) <= '9')
                        sum = (sum * 10) + (int)(s.charAt(k) - '0');
                    k++;
                }
                k--;
                
                numStk.push(sum);
            }
            
            else {
                if(c == '(')
                    opStk.push(c);
                
                else if(c == ')' || c == '+' || c == '-') {
                    while(!opStk.empty() && opStk.peek() != '(') {
                        a = numStk.pop();
                        b = numStk.pop();
                        op = opStk.pop();
                        
                        if(op == '+')
                            numStk.push(b + a);
                        else if(op == '-')
                            numStk.push(b - a);
                    }
                    
                    if(c == ')')
                        opStk.pop();
                    else
                        opStk.push(c);
                }
            }
        }
        
        while(!opStk.empty()) {
            a = numStk.pop();
            b = numStk.pop();
            op = opStk.pop();

            if(op == '+')
                numStk.push(b + a);
            else if(op == '-')
                numStk.push(b - a);
        }
        
        return numStk.pop();
    }
}
