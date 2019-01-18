// 23. Merge k Sorted Lists
// Accepted 373ms

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    // Winner tree: O(N * K * logK), where K means the number of sorted lists, N means the total number of elements
    public ListNode mergeKLists(ListNode[] lists) {
        int k = lists.length, idx;
        int level = (int)Math.ceil(Math.log((double)k) / Math.log((double)2)) + 1;
        int nodeNum = (int)Math.pow((double)2, (double)level);
        int lastLevelNum = (nodeNum >> 1);
        int lastLevelStart = lastLevelNum;
        int levelStart;
        long[] winner = new long[nodeNum];
        boolean endFlag = false;
        ListNode ret = new ListNode(-1);
        ListNode retHead = ret;
        
        for(int i = 0; i < lastLevelNum; ++i) {
            if(i < k && lists[i] != null)
                winner[i + lastLevelStart] = (long)lists[i].val;
            else
                winner[i + lastLevelStart] = Long.MAX_VALUE;
        }
        
        while(!endFlag) {
            endFlag = true;
            for(int i = 0; i < k; i++) {
                if(lists[i] != null) {
                    endFlag = false;
                    break;
                }
            }
            if(endFlag)
                break;
            
            levelStart = lastLevelStart;
            while(levelStart > 1) {
                for(int i = levelStart; i < levelStart + levelStart; i += 2) {
                    winner[i >> 1] = winner[i] < winner[i + 1] ? winner[i] : winner[i + 1];
                }
                
                levelStart >>= 1;
            }
            
            ret.next = new ListNode((int)winner[1]);
            ret = ret.next;
            
            idx = 1;
            while(idx < lastLevelStart) {
                if(winner[idx << 1] == winner[idx])
                    idx <<= 1;
                else
                    idx = (idx << 1) + 1;
            }
            
            if(lists[idx - lastLevelStart] != null)
                lists[idx - lastLevelStart] = lists[idx - lastLevelStart].next;
            winner[idx] = lists[idx - lastLevelStart] != null ? (long)lists[idx - lastLevelStart].val : Long.MAX_VALUE;
        }
        
        return retHead.next;
    }
}
