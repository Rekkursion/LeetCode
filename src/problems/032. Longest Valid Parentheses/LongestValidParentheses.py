# 32. Longest Valid Parentheses
# Accepted 92ms

class Solution:
    class __Interval:
        def __init__(self, left, right):
            self.start = left
            self.end = right
        def __gt__(self, other):
            return self.start > other.start
        def __lt__(self, other):
            return self.start < other.start
        def __ge__(self, other):
            return self.start >= other.start
        def __le__(self, other):
            return self.start <= other.start
        def __eq__(self, other):
            return self.start == other.start
        def __ne__(self, other):
            return self.start != other.start
        def __str__(self):
            return '({s}, {e})'.format(s = self.start, e = self.end)
        def __len__(self):
            return self.end - self.start + 1
        
        @classmethod
        def mergeIntervals(cls, intervals):
            retIdx, ret = 0, []
            for idx, val in enumerate(intervals):
                if retIdx > 0 and ret[retIdx - 1].end + 1 == val.start:
                    ret[retIdx - 1].end = val.end
                elif retIdx == 0 or ret[retIdx - 1].end < val.start:
                    ret.append(cls(val.start, val.end))
                    retIdx += 1
            
            return ret
    
    def longestValidParentheses(self, s):
        """
        :type s: str
        :rtype: int
        """
        stack = []
        Interval = self.__Interval
        intervals = []
        
        for idx, ch in enumerate(s):
            if ch == '(':
                stack.append(idx)
            elif ch == ')':
                if len(stack) > 0:
                    bisect.insort_left(intervals, Interval(stack.pop(), idx))
        
        intervals = Interval.mergeIntervals(intervals)
        return max([len(interval) for interval in intervals] + [0])
