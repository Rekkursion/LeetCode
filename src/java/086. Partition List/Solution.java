// 86. Partition List
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
    public ListNode partition(ListNode head, int x) {
        ListNode less = new ListNode(-1);
        ListNode lessHead = less;
        ListNode eBigger = new ListNode(-1);
        ListNode eBiggerHead = eBigger;
        ListNode p = head;
        
        while(p != null) {
            ListNode newNode = new ListNode(p.val);
            newNode.next = null;
            
            if(p.val < x) {
                less.next = newNode;
                less = less.next;
            }
            else {
                eBigger.next = newNode;
                eBigger = eBigger.next;
            }
            
            p = p.next;
        }
        
        less.next = eBiggerHead.next;
        
        return lessHead.next;
    }
}
