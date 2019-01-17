// 56. Merge Intervals
// Accepted 19ms

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> ret = new ArrayList<>();
        int curS = 0, curE = 0;
        
        if(intervals.size() == 0)
            return ret;
        
        //Collections.sort(intervals, (a, b) -> (a.start < b.start) ? -1 : ((a.start > b.start) ? 1 : ((a.end < b.end) ? -1 : 1)));
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval a, Interval b) {
                return (a.start - b.start);
            }
        });
        
        //Interval[] intervalsArr = new Interval[intervals.size()];
        //intervals.toArray(intervalsArr);
        //Arrays.sort(intervalsArr, new Comparator<Interval>() {
        //    @Override
        //    public int compare(Interval a, Interval b) {
        //        return (a.start - b.start);
        //    }
        //});
        
        curS = intervals.get(0).start;
        curE = intervals.get(0).end;
        
        for(int k = 1; k < intervals.size(); k++) {
            if(intervals.get(k).start <= curE)
                curE = Math.max(curE, intervals.get(k).end);
            
            else {
                ret.add(new Interval(curS, curE));
                curS = intervals.get(k).start;
                curE = intervals.get(k).end;
            }
        }
        ret.add(new Interval(curS, curE));
        
        return ret;
    }
}
