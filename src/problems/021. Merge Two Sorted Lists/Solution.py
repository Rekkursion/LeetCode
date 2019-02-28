# 21. Merge Two Sorted Lists
# Accepted 44ms

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def mergeTwoLists(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        
        ret = ListNode(-1)
        retHead = ret
        
        while l1 != None and l2 != None:
            if l1.val < l2.val:
                newNode = ListNode(l1.val)
                l1 = l1.next
            else:
                newNode = ListNode(l2.val)
                l2 = l2.next
            ret.next = newNode; ret = ret.next
        
        while l1 != None:
            ret.next = ListNode(l1.val); ret = ret.next
            l1 = l1.next
        while l2 != None:
            ret.next = ListNode(l2.val); ret = ret.next
            l2 = l2.next
        
        return retHead.next
