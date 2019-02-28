# 19. Remove Nth Node From End of List
# Accepted 56ms

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def removeNthFromEnd(self, head, n):
        """
        :type head: ListNode
        :type n: int
        :rtype: ListNode
        """
        dummy = ListNode(-1)
        dummy.next = head
        
        count = 0
        p = head
        while p != None:
            count += 1
            p = p.next
        n = count - n + 1
        
        count = 1
        p, q = head, dummy
        while p != None:
            if count == n:
                q.next = p.next
                break
            count += 1
            q = p
            p = p.next
        
        return dummy.next
