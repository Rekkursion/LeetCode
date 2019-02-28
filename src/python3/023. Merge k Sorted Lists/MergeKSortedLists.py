# 23. Merge k Sorted Lists
# Accepted 80ms

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def mergeKLists(self, lists):
        """
        :type lists: List[ListNode]
        :rtype: ListNode
        """
        ret = []
        for node in lists:
            p = node
            while(p != None):
                bisect.insort_right(ret, p.val)
                p = p.next
        
        
        return ret
        
