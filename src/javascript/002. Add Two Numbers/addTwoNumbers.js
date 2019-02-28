// 2. Add Two Numbers
// Accepted 124ms

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
var addTwoNumbers = function(l1, l2) {
    let ret = new ListNode(-1);
    let retHead = ret;
    let carry = 0;
    
    while(l1 != null || l2 != null || carry != 0) {
        let a = (l1 == null) ? 0 : l1.val;
        let b = (l2 == null) ? 0 : l2.val;
        
        let newNode = new ListNode((a + b + carry) % 10);
        carry = parseInt(Math.floor((a + b + carry) / 10));
        
        ret.next = newNode;
        ret = ret.next;
        
        if(l1 != null)
            l1 = l1.next;
        if(l2 != null)
            l2 = l2.next;
    }
    
    return retHead.next;
};
