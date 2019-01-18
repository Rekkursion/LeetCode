// 25. Reverse Nodes in k-Group
// Accepted 14ms

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null || k <= 1)
            return head;
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        ListNode pre_p = dummy, p = head;
        ListNode pre_q = dummy, q = head;
        ListNode nextStart = head;
        int count = 1, swapCount = 0;
        
        while(p != null && q != null) {
            if(count == k) {
                
                swapCount = 0;
                while (p != q && q.next != p) {
                    swapCount++;
                    
                    pre_p.next = q;
                    pre_q.next = p;
                    pre_p = q.next;
                    if(swapCount == 1)
                        nextStart = pre_p;
                    q.next = p.next;
                    p.next = pre_p;
                    
                    p = q.next;
                    pre_p = q;
                    q = pre_q;
                    pre_q = pre_p;
                    while(pre_q.next != q)
                        pre_q = pre_q.next;
                }
                
                while(pre_p.next != nextStart)
                    pre_p = pre_p.next;
                pre_q = pre_p;
                p = nextStart;
                q = nextStart;
                
                count = 1;
            }
            
            if(p == null || q == null)
                break;
            
            if(count < k) {
                count++;
                pre_q = q;
                q = q.next;
            }
        }
        
        return dummy.next;
    }
}
