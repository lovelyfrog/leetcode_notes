import java.math.BigInteger;
class Solution {
    class TreeNode {
        TreeNode left;
        TreeNode right;
        int treeNodeNum;
        int val;
        TreeNode (TreeNode left, TreeNode right, int treeNodeNum, int val) {
            this.left = left;
            this.right = right;
            this.treeNodeNum = treeNodeNum;
            this.val = val;
        }
    }
    int mod = (int)(1e9 + 7);
    public int numOfWays(int[] nums) {
        TreeNode root = buildTree(nums);
        return (int)(numOfWays(root) - 1);
    }
    public TreeNode buildTree(int[] nums) {
        TreeNode root = new TreeNode(null, null, 1, nums[0]);
        for (int i = 1; i < nums.length; i++) {
            TreeNode tmp = root;
            while (true) {
                if (nums[i] > tmp.val) {
                    if (tmp.right == null) {
                        tmp.right = new TreeNode(null, null, 1, nums[i]);
                        tmp.treeNodeNum++;
                        break;
                    }
                    tmp.treeNodeNum++;
                    tmp = tmp.right;
                }
                if (nums[i] < tmp.val) {
                    if (tmp.left == null) {
                        tmp.left = new TreeNode(null, null, 1, nums[i]);
                        tmp.treeNodeNum++;
                        break;
                    }
                    tmp.treeNodeNum++;
                    tmp = tmp.left;
                }
            }
        }
        return root;
    } 
    public int numOfWays(TreeNode root) {
        if (root == null) return 0;
        int leftNum, rightNum, choiceNum;
        BigInteger res = BigInteger.valueOf(1);
        leftNum = (root.left == null)?1: numOfWays(root.left);
        rightNum = (root.right == null)?1: numOfWays(root.right);
        choiceNum = (root.left == null || root.right == null)?1: countNum(root.left.treeNodeNum, root.treeNodeNum-1);
        return res.multiply(BigInteger.valueOf(leftNum)).multiply(BigInteger.valueOf(rightNum)).multiply(BigInteger.valueOf(choiceNum)).mod(BigInteger.valueOf(mod)).intValue(); 
    }
    public int countNum(int m, int n) {
        BigInteger res = BigInteger.valueOf(1);
        for (int i = 0; i < m; i++) {
            res = res.multiply(BigInteger.valueOf(n-i)).divide(BigInteger.valueOf(1+i));
        }
        return res.mod(BigInteger.valueOf(mod)).intValue();
    }
}
