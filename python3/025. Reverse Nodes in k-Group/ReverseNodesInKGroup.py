# 25. Reverse Nodes in k-Group
# Accepted 232ms

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def reverseKGroup(self, head, k):
        """
        :type head: ListNode
        :type k: int
        :rtype: ListNode
        """
        if k == 1:
            return head
        
        dummy = ListNode(-1)
        dummy.next = head
        
        count = 0
        p = q = head
        pre_p = pre_q = dummy
        
        while q != None:
            count += 1
            if count == k:
                first = True
                while q.next != p and q != p:
                    pre_p.next = q
                    pre_q.next = p
                    nS = q.next
                    q.next = p.next
                    p.next = nS
                    
                    if first:
                        nextPreStart = p
                        first = False
                    
                    p = q.next
                    pre_p = q
                    while q.next != pre_q:
                        q = q.next
                    pre_q = q
                    q = q.next
                
                count = 0
                if not first:
                    pre_p = pre_q = nextPreStart
                    p = q = nextPreStart.next
            else:
                pre_q = q
                q = q.next
        
        return dummy.next
