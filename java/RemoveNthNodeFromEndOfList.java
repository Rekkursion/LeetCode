// 19. Remove Nth Node From End of List
// 11ms

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p = head, q = head;
        int len = 0, idx;
        
        while(p != null) {
            len++;
            p = p.next;
        }
        
        idx = (len - n) + 1;
        len = 0;
        p = head;
        
        while(p != null) {
            len++;
            if(len == idx)
                break;
            
            q = p;
            p = p.next;
        }
        
        if(p == head)
            return head.next;
        else if(p == null)
            q.next = null;
        else
            q.next = p.next;
        
        return head;
    }
}
