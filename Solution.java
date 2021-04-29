class Solution {
    List<List<Integer>> ans = new LinkedList<>();
    List<Integer> curr = new LinkedList<>();
    int n;
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        n = nums.length;
        int[] isVisited = new int[n];
        backTrack(nums, 0, isVisited);
        return ans;
    }
    public void backTrack(int[] nums, int i, int[] isVisited) {
        if (i == n) {
            ans.add(new LinkedList<>(curr));
            return;
        }
        for (int k = 0; k < nums.length; k++) {
            if (isVisited[k] == 0) {
                if (k > 0 && nums[k] == nums[k-1] && isVisited[k-1] == 0) continue;
                curr.add(nums[k]);
                isVisited[k] = 1;
                backTrack(nums, i+1, isVisited);
                curr.remove(curr.size()-1);
                isVisited[k] = 0;
            }
        }

    }
}       