// 24. Swap Nodes in Pairs
// Accepted 60ms

/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var swapPairs = function(head) {
    let dummy = new ListNode(-1);
    dummy.next = head;
    
    let [p, q] = [head, dummy];
    while(p && p.next) {
        let tmpNode = p.next;
        
        p.next = tmpNode.next;
        q.next = tmpNode;
        tmpNode.next = p;
        
        q = p;
        p = p.next;
    }
    
    return dummy.next;
};
