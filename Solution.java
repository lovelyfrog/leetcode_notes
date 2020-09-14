class Solution {
    public int minimumOperations(String leaves) {
        int n = leaves.length();
        int[][] dp = new int[n][3];
        dp[0][0] = (leaves.charAt(0) == 'r')?0: 1;
        dp[0][1] = (int)1e5;
        dp[0][2] = (int)1e5;
        for (int i = 1; i < n; i++) {
            char c = leaves.charAt(i);
            dp[i][0] = dp[i-1][0] + cost(c, 'r');
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][1]) + cost(c, 'y');
            dp[i][2] = Math.min(dp[i-1][1], dp[i-1][2]) + cost(c, 'r');
        }
        return dp[n-1][2];
    }
    public int cost(char a, char b) {
        return (a == b)?0:1;
    }
}