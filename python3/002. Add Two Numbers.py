# 2. Add Two Numbers
# Accepted 96ms

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def addTwoNumbers(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        ret = ListNode(-1)
        retHead = ret
        carry = 0
        
        while l1 != None or l2 != None or carry != 0:
            a = 0 if l1 == None else l1.val
            b = 0 if l2 == None else l2.val
            
            sum = a + b + carry
            carry = sum // 10
            
            ret.next = ListNode(sum % 10)
            ret = ret.next
            
            l1 = None if l1 == None else l1.next
            l2 = None if l2 == None else l2.next
        
        return retHead.next
