// 2. Add Two Numbers
// Accepted 43ms

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ret = new ListNode(-1);
        ListNode retPtr = ret;
        int num1, num2, sum, carry;
        
        carry = 0;
        while(l1 != null || l2 != null || carry > 0) {
            
            num1 = (l1 == null) ? 0 : l1.val;
            num2 = (l2 == null) ? 0 : l2.val;
            sum = num1 + num2 + carry;
            
            carry = sum / 10;
            ret.val = sum % 10;
            if(carry > 0 || (l1 != null && l1.next != null) || (l2 != null && l2.next != null))
                ret.next = new ListNode(-1);
            ret = ret.next;
            
            if(l1 != null)
                l1 = l1.next;
            if(l2 != null)
                l2 = l2.next;
        }
        
        return retPtr;
    }
}
