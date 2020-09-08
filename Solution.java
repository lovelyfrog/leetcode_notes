class Solution {
    List<List<Integer>> ans = new LinkedList<>();
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> curr = new LinkedList<>();
        backTrack(curr, 1, n, k);
        return ans;
    }
    public void backTrack(List<Integer> curr, int start, int end, int k) {
        if (k == 0) {
            ans.add(new LinkedList<Integer>(curr));
            return;
        };
        for (int i = start; i <= end - k + 1; i++) {
            curr.add(i);
            backTrack(curr, i+1, end, k-1);
            curr.remove(curr.size()-1);
        }
    }
}
