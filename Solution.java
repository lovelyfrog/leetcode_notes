class Solution {
    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        int[][] sum = new int[n][n];
        for (int i = n-1; i >= 0; i--) {
            for (int j = n-1; j >= i; j--) {
                if (j == i) sum[i][j] = nums[i];
                if (j > i) sum[i][j] = sum[i+1][j] + nums[i];
            }
        }
        for (int i = n-1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (j == i) dp[i][j] = nums[i];
                if (j > i) dp[i][j] = sum[i][j] - Math.min(dp[i+1][j], dp[i][j-1]);
            }
        }
        if (dp[0][n-1] >= sum[0][n-1] - dp[0][n-1]) return true;
        return false;
    }
}
