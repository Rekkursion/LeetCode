// 21. Merge Two Sorted Lists
// Accepted 76ms

/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @return {ListNode}
 */
var mergeTwoLists = function(l1, l2) {
    let [p, q] = [l1, l2];
    let dummy = new ListNode(-1);
    let it = dummy;
    
    while(p && q) {
        if(p.val < q.val) {
            it.next = new ListNode(p.val);
            p = p.next;
        } else {
            it.next = new ListNode(q.val);
            q = q.next;
        }
        it = it.next;
    }
    while(p) {
        it.next = new ListNode(p.val);
        [it, p] = [it.next, p.next];
    }
    while(q) {
        it.next = new ListNode(q.val);
        [it, q] = [it.next, q.next];
    }
    
    return dummy.next;
};
