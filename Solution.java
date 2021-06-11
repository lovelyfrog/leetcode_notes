class Solution {
    public int numSquares(int n) {
        int l = n;
        // int[][] dp = new int[l+1][n+1];
        int[] dp = new int[n+1];
        
        for (int j = 1; j <= n; j++) {
            dp[j] = j;
        }

        for (int i = 1; i*i <= l; i++) {
            for (int j = 1; j <= n; j++) {
                int tmp = j - i*i;
                if (tmp >= 0) dp[j] = Math.min(dp[j], dp[tmp] + 1);
                // int k = 1;
                // while (tmp >= 0) {
                //     if (dp[j] != 0) {
                //         dp[j] = Math.min(dp[j], dp[tmp]+k);
                //     } else {
                //         dp[j] = dp[tmp] + 1;
                //     }
                //     tmp -= i*i;
                //     k++;
                // }
            }
        }
        return dp[n];
    }
}