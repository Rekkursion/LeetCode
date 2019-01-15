// 589. N-ary Tree Preorder Traversal
// Accepted 11ms

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    public List<Integer> preorder(Node root) {
        Stack<Node> stk = new Stack<Node>();
        Node curNode;
        List<Integer> ret = new ArrayList<Integer>();
        
        if(root == null)
            return ret;
        
        stk.push(root);
        
        while(!stk.empty()) {
            curNode = stk.pop();
            
            for(int k = curNode.children.size() - 1; k >= 0; k--)
                stk.push(curNode.children.get(k));
            
            ret.add(curNode.val);
        }
        
        return ret;
    }
}
