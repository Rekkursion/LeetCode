// 61. Rotate List
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
    public ListNode rotateRight(ListNode head, int k) {
        if(k == 0)
            return head;
        
        int count = 0, size = 0;
        ListNode p = head;
        ListNode ret = new ListNode(-1);
        ListNode retHead = ret;
        
        while(p != null) {
            count++;
            p = p.next;
        }
        
        size = count;
        if(size == 0)
            return head;
        k %= size;
        
        count = 0;
        p = head;
        while(p != null) {
            if(count >= (size - k)) {
                ret.next = new ListNode(p.val);
                ret = ret.next;
            }
            
            count++;
            p = p.next;
        }
        
        count = 0;
        p = head;
        while(p != null && count < (size - k)) {
            ret.next = new ListNode(p.val);
            ret = ret.next;
            
            count++;
            p = p.next;
        }
        
        return retHead.next;
    }
}
