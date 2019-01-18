// 24. Swap Nodes in Pairs
// Accepted 3ms

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null)
            return head;
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        ListNode x = dummy;
        ListNode y = head;
        ListNode z = head.next;
        
        while(z != null) {
            y.next = z.next;
            z.next = y;
            x.next = z;
            
            x = y;
            y = y.next;
            if(y == null)
                break;
            else
                z = y.next;
        }
        
        return dummy.next;
    }
}
