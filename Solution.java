class Solution {
    List<List<Integer>> ans = new LinkedList<>();
    List<Integer> curr = new LinkedList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        backTrack(1, n, k);
        return ans;
    }
    public void backTrack(int p, int n, int numLeft) {
        if (n == 0 && numLeft == 0) {
            ans.add(new LinkedList<>(curr));
            return;
        }
        if (n <= 0 || numLeft <= 0) return;
        backTrack(p+1, n, numLeft);
        curr.add(p);
        backTrack(p+1, n-p, numLeft-1);
        curr.remove(curr.size()-1);
    }
}
