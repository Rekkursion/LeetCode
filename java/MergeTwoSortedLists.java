// 21. Merge Two Sorted Lists
// Accepted 16ms

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
        
        while(l1 != null || l2 != null) {
            
            if(l1 != null && l2 != null) {
                if(l1.val < l2.val) {
                    ListNode newNode = new ListNode(l1.val);
                    newNode.next = null;
                    ret.next = newNode;
                    
                    l1 = l1.next;
                }
                else if(l1.val > l2.val) {
                    ListNode newNode = new ListNode(l2.val);
                    newNode.next = null;
                    ret.next = newNode;
                    
                    l2 = l2.next;
                }
                else {
                    ListNode newNode = new ListNode(l1.val);
                    newNode.next = null;
                    ret.next = newNode;
                    
                    ret = ret.next;
                    l1 = l1.next;
                    
                    newNode = new ListNode(l2.val);
                    newNode.next = null;
                    ret.next = newNode;
                    
                    l2 = l2.next;
                }
            }
            
            else if(l1 != null) {
                ListNode newNode = new ListNode(l1.val);
                newNode.next = null;
                ret.next = newNode;

                l1 = l1.next;
            }
            
            else {
                ListNode newNode = new ListNode(l2.val);
                newNode.next = null;
                ret.next = newNode;

                l2 = l2.next;
            }
            
            ret = ret.next;
        }
        
        return head.next;
    }
}
