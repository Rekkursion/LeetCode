// 2. Add Two Numbers
// Accepted 16ms

/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {
    var ret *ListNode = &ListNode{ 0, nil }
    var retHead = ret
    var carry int = 0
    
    for l1 != nil || l2 != nil || carry != 0 {
        var a, b, sum int = 0, 0, 0
        
        if(l1 == nil) { a = 0 } else { a = l1.Val }
        if(l2 == nil) { b = 0 } else { b = l2.Val }
        sum = a + b + carry
        carry = sum / 10
        
        ret.Next = &ListNode{ 0, nil }
        ret = ret.Next
        ret.Val = sum % 10
        
        if(l1 != nil) { l1 = l1.Next }
        if(l2 != nil) { l2 = l2.Next }
    }
    
    return retHead.Next
}
