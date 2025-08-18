/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    int maxDiam = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) {
            return 0;
        }    

        DFS(root);

        return maxDiam;
    }

    private int DFS(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int left = DFS(root.left);
        int right = DFS(root.right);

        maxDiam = Math.max(maxDiam, left + right);

        return Math.max(left, right) + 1;
    }
}