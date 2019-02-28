// 725. Split Linked List in Parts
// Accepted 6ms

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode[] splitListToParts(ListNode root, int k) {
        int[] splittedSize = new int[k];
        int origSize = 0, restSize, idx, lastIdx, count;
        ListNode p = root;
        ListNode[] ret = new ListNode[k];
        ListNode[] retHead = new ListNode[k];
        
        while(p != null) {
            origSize++;
            p = p.next;
        }
        Arrays.fill(splittedSize, (int)Math.floor((double)origSize / k));
        restSize = origSize - (splittedSize[0] * k);
        
        idx = 0;
        while(restSize > 0) {
            if(idx == k)
                idx = 0;
            
            splittedSize[idx++]++;
            restSize--;
        }
        
        p = root;
        idx = 0;
        lastIdx = -1;
        count = 0;
        while(p != null) {
            if(count == splittedSize[idx]) {
                idx++;
                count = 0;
            }
            
            if(lastIdx != idx) {
                ret[idx] = new ListNode(-1);
                retHead[idx] = ret[idx];
                lastIdx = idx;
            }
            
            ret[idx].next = new ListNode(p.val);
            ret[idx] = ret[idx].next;
            
            count++;
            p = p.next;
        }
        
        for(idx = 0; idx < k; ++idx) {
            if(retHead[idx] != null && retHead[idx].next != null)
                retHead[idx] = retHead[idx].next;
        }
        
        return retHead;
    }
}
