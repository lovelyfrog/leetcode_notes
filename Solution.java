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
    TreeNode up;
    public String smallestFromLeaf(TreeNode root) {
        up = root;
        StringBuffer ans = new StringBuffer();
        StringBuffer tmp = new StringBuffer();
        backTrack(root, tmp, ans);
        return ans.toString();
    }
    public void backTrack(TreeNode root, StringBuffer tmp, StringBuffer ans) {
        if (root == null) return;
        tmp.append((char)(root.val + 'a'));
        if (root.left == null && root.right == null) {
            if (compare(tmp.reverse(), ans) < 0) {
                ans.delete(0, ans.length());
                ans.append(tmp.toString());
            }
            tmp.reverse();
            tmp.delete(tmp.length()-1, tmp.length());
            return;
        }
        backTrack(root.left, tmp, ans);
        backTrack(root.right, tmp, ans);
        tmp.delete(tmp.length()-1, tmp.length());
    }
    public int compare(StringBuffer a, StringBuffer b) {
        if (a.length() == 0 && b.length() == 0) return 0;
        if (a.length() == 0) return 1;
        if (b.length() == 0) return -1;
        int i = 0;
        while (i < a.length() && i < b.length()) {
            if (a.charAt(i) == b.charAt(i)) {
                i++;
            } else if (a.charAt(i) > b.charAt(i)) {
                return 1;
            } else {
                return -1;
            }
        }
        if (i == a.length() && i == b.length()) return 0;
        if (i == a.length()) return -1;
        return 1;
    }
}
