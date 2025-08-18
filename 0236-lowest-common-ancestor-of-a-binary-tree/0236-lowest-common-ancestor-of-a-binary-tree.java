/*
https://www.youtube.com/watch?v=_-QHfMDde90


                1
               /  \
              /    \
             2      6
            / \      \
           /   \      \
          3     4      7
                 \    /
                  \  8
                   5
                   
   Ancestor of 5 and 7 would be 1.                
   
   Case 1:
   5 will return 5 to the node 4
   4 will send 5 to node 2
   2 will send 5 to node 1

        Inshort 1 will get 5 from the left side of the tree
            
   Case 1:
   7 will return 7 to the node 6
   6 will send 7 to node 1
    
        Inshort 1 will get 7 from the right side of the tree
   
   Case 1: 
   Node 1 will get 5 from Left subtree and 7 from right subtree. Node 1 will return as answer.
            
*/
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return null;
        }

        if(root.val == p.val || root.val == q.val) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left != null && right != null) {
            return root;
        }

        return left == null ? right : left;
    }
} 