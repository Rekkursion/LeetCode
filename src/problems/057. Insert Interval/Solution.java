// 57. Insert Interval
// Accepted 11ms

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
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> ret = new ArrayList<>();
        int _start = newInterval.start, _end = newInterval.end;
        boolean overlapping = false, finished = false;
        
        for(Interval interval: intervals) {
            if(interval.end >= newInterval.start && !overlapping && !finished) {
                if(interval.start > newInterval.end) {
                    ret.add(new Interval(newInterval.start, newInterval.end));
                    ret.add(new Interval(interval.start, interval.end));
                    finished = true;
                }
                else {
                    overlapping = true;
                    _start = Math.min(interval.start, newInterval.start);
                    _end = Math.max(interval.end, newInterval.end);
                }
            }
            else {
                if(overlapping) {
                    if(interval.start > newInterval.end) {
                        ret.add(new Interval(_start, _end));
                        ret.add(new Interval(interval.start, interval.end));
                        finished = true;
                        overlapping = false;
                    }
                    else {
                        if(interval.end >= newInterval.end) {
                            ret.add(new Interval(_start, interval.end));
                            finished = true;
                            overlapping = false;
                        }
                    }
                }
                else
                    ret.add(new Interval(interval.start, interval.end));   
            }
        }
        
        if(!finished)
            ret.add(new Interval(_start, _end));
        
        return ret;
    }
}
