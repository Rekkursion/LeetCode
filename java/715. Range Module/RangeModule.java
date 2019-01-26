// 715. Range Module
// Accepted 667ms

// Test case
// ["RangeModule","addRange","removeRange","queryRange","queryRange","queryRange"]
// [[],[10,20],[14,16],[10,14],[13,15],[16,17]]

class RangeModule {
    private class Interval {
        private int start;
        private int end;
        private Interval() {}
        private Interval(int s, int e) { this.start = s; this.end = e; }
    }
    private List<Interval> intervals = new ArrayList<>();

    public RangeModule() {
        intervals.clear();
    }
    
    public void addRange(int left, int right) {
        boolean overlapping = false, finished = false;
        Interval curInt;
        List<Interval> newInts = new ArrayList<>();
        int curS = left, curE = right;
        
        for(int k = 0; k < intervals.size(); k++) {
            curInt = intervals.get(k);
            
            if(left <= curInt.end && !overlapping && !finished) {
                if(right < curInt.start) {
                    finished = true;
                    newInts.add(new Interval(left, right));
                    newInts.add(new Interval(curInt.start, curInt.end));
                }
                else {
                    overlapping = true;
                    curS = Math.min(left, curInt.start);
                    curE = Math.max(right, curInt.end);
                }
            }
            else {
                if(overlapping) {
                    if(curE < curInt.start) {
                        overlapping = false;
                        finished = true;
                        newInts.add(new Interval(curS, curE));
                        newInts.add(new Interval(curInt.start, curInt.end));
                    }
                    else {
                        curE = Math.max(curE, curInt.end);
                    }
                }
                else
                    newInts.add(new Interval(curInt.start, curInt.end));
            }
        }
        
        if(!finished)
            newInts.add(new Interval(curS, curE));
        
        intervals = newInts;
        //for(Interval interval: intervals)
        //    System.out.println(interval.start + ", " + interval.end);
        //System.out.println("+");
        
        return;
    }
    
    public boolean queryRange(int left, int right) {
        for(Interval curInt: intervals) {
            if(left >= curInt.start && right <= curInt.end)
                return true;
        }
        
        return false;
    }
    
    public void removeRange(int left, int right) {
        List<Interval> newInts = new ArrayList<>();
        Interval curInt;
        
        for(int k = 0; k < intervals.size(); k++) {
            curInt = intervals.get(k);
            
            if(left <= curInt.start && right < curInt.end)
                newInts.add(new Interval(Math.max(right, curInt.start), curInt.end));
            else if(left > curInt.start && right >= curInt.end)
                newInts.add(new Interval(curInt.start, Math.min(left, curInt.end)));
            else if(left > curInt.start && right < curInt.end) {
                newInts.add(new Interval(curInt.start, left));
                newInts.add(new Interval(right, curInt.end));
            }
        }
        
        intervals = newInts;
        //for(Interval interval: intervals)
        //    System.out.println(interval.start + ", " + interval.end);
        //System.out.println("-");
        
        return;
    }
}

/**
 * Your RangeModule object will be instantiated and called as such:
 * RangeModule obj = new RangeModule();
 * obj.addRange(left,right);
 * boolean param_2 = obj.queryRange(left,right);
 * obj.removeRange(left,right);
 */
