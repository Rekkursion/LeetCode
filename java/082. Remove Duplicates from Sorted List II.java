// 82. Remove Duplicates from Sorted List II
// Accepted 0ms

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
        int dupVal;
        
        dummy.next = head;
        p = head;
        q = dummy;
        
        while(p != null) {
            if(p.next != null && p.next.val == p.val) {
                dupVal = p.val;
                while(p != null && p.val == dupVal)
                    p = p.next;                
                q.next = p;
            }
            else {
                q = p;
                p = p.next;
            }
        }
        
        return dummy.next;
    }
}
