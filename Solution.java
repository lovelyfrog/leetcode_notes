/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode invertTree(TreeNode root) {
        helper(root);
        return root; 
    }
    public void helper(TreeNode root) {
        if (root == null) return;
        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = tmp;
        helper(root.left);
        helper(root.right);
    }
}