// 147. Insertion Sort List
// Accepted 40ms

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head == null)
            return head;
        
        ListNode dummy = new ListNode(-1);
        ListNode it, q, p, insLoc;
        
        dummy.next = head;
        p = head;
        q = dummy;
        it = head.next;
        
        while(it != null) {
            insLoc = q.next;
            while(insLoc != it) {
                if(insLoc.val >= it.val)
                    break;
                
                q = insLoc;
                insLoc = insLoc.next;
            }
            
            q.next = it;
            q = it.next;
            it.next = insLoc;
            if(insLoc == it)
                p = p.next;
            p.next = q;
            it = q;
            q = dummy;
        }
        
        return dummy.next;
    }
}
