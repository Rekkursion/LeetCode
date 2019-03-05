// 19. Remove Nth Node From End of List
// Accepted 72ms

ListNode.prototype.getLen = function() {
    let it = this;
    let len = 0;
    
    while(it) {
        ++len;
        it = it.next;
    }
    
    return len;
}

/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} head
 * @param {number} n
 * @return {ListNode}
 */
var removeNthFromEnd = function(head, n) {
    let dummy = new ListNode(-1);
    dummy.next = head;
    
    let [p, q] = [head, dummy];
    let [len, counter] = [head.getLen(), 0];
    
    while(p && counter < len - n) {
        ++counter;
        [q, p] = [p, p.next];
    }
    
    if(p)
        q.next = p.next;
    
    return dummy.next;
};
