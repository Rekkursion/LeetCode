// 23. Merge k Sorted Lists
// Accepted 116ms

/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode[]} lists
 * @return {ListNode}
 */
var mergeKLists = function(lists) {
    let retArr = Array();
    let dummy = new ListNode(-1);
    let ret = dummy;
    
    for(let node of lists) {
        let p = node;
        while(p) {
            retArr.push(p.val);
            p = p.next;
        }
    }
    
    retArr.sort((a, b) => a - b);
    
    for(let val of retArr) {
        ret.next = new ListNode(val);
        ret = ret.next;
    }
    
    return dummy.next;
};
