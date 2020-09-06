class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int k = 1;
        while (queue.size() != 0) {
            int num = 0;
            List<Integer> tmpList = new LinkedList<>();
            while (k != 0) {
                TreeNode tmp = queue.poll();
                tmpList.add(tmp.val);
                if (tmp.left != null) {
                    queue.offer(tmp.left);
                    num++;
                }
                if (tmp.right != null) {
                    queue.offer(tmp.right);
                    num++;
                }
                k--;
            }
            k = num;
            ans.insert(0, tmpList);
        }
        return ans;
    }
}
