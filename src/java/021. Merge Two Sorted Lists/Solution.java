// 21. Merge Two Sorted Lists
// Accepted 15ms

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode ret = new ListNode(-1);
        ListNode head = ret;
        
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                ret.next = l1;
                l1 = l1.next;
            }
            else {
                ret.next = l2;
                l2 = l2.next;
            }
            
            ret = ret.next;
        }
        
        if(l1 != null)
            ret.next = l1;
        if(l2 != null)
            ret.next = l2;
        
        return head.next;
    }
}
