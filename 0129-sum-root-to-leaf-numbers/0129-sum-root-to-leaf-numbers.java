class Solution {

    List<Integer> list;
    public int sumNumbers(TreeNode root) {
        list = new ArrayList<>();

        DFS(root, root.val);

        int result = 0;

        for(int a : list) {
            result += a;
        }

        return result;
    }

    private void DFS(TreeNode root, int val) {
        if(root == null) {
            return;
        }

        if(root.left == null && root.right == null) {
            list.add(val);
        }

        if(root.left != null) {
            DFS(root.left, val * 10 + root.left.val);
        }

        if(root.right != null) {
            DFS(root.right, val * 10 + root.right.val);
        }
    }
}