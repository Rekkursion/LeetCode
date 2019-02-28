// 83. Remove Duplicates from Sorted List
// Accepted 1ms

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode p, q;
        
        dummy.next = head;
        p = head;
        q = dummy;
        
        while(p != null) {
            while(p.next != null && p.next.val == p.val)
                p = p.next;
            
            q.next = p;
            q = p;
            if(p != null)
                p = p.next;
        }
        
        return dummy.next;
    }
}
