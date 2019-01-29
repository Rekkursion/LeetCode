# 24. Swap Nodes in Pairs
# Accepted 44ms

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def swapPairs(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if head == None or head.next == None:
            return head
        
        dummy = ListNode(-1)
        dummy.next = head
        
        p = dummy
        q = head
        r = head.next
        
        while r != None:
            q.next = r.next
            r.next = q
            p.next = r
            
            p = q
            q = q.next
            r = None if q == None else q.next
        
        return dummy.next
