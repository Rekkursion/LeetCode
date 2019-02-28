// 32. Longest Valid Parentheses
// Accepted 21ms

public class Solution {
    private class Interval implements Comparable<Interval> {
        private int start;
        private int end;
        
        private Interval() {}
        private Interval(int s, int e) { start = s; end = e; }
        
        @Override
        public int compareTo(Interval rhs) {
            return (this.start - rhs.start);
        }
    }
    
    public int longestValidParentheses(String s) {
        ArrayDeque<Integer> openStk = new ArrayDeque<>();
        List<Interval> ranges = new ArrayList<>();
        int longest = 0, left, right;
        
        for(int k = 0; k < s.length(); ++k) {
            if(s.charAt(k) == '(')
                openStk.push(k);
            else {
                if(!openStk.isEmpty()) {
                    ranges.add(new Interval(openStk.pop(), k));
                }
            }
        }
        
        if(ranges.size() == 0)
            return longest;
        
        Collections.sort(ranges);
        
        left = ranges.get(0).start;
        right = ranges.get(0).end;
        for(int k = 1; k < ranges.size(); ++k) {
            if(ranges.get(k).start < right)
                continue;
                
            if(ranges.get(k).start - 1 == right)
                right = ranges.get(k).end;
            else {
                if(right - left + 1 > longest)
                    longest = right - left + 1;
                
                left = ranges.get(k).start;
                right = ranges.get(k).end;
            }
        }
        if(right - left + 1 > longest)
            longest = right - left + 1;
        
        return longest;
    }
}
