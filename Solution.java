class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int l = strs.length;
        int[][][] dp = new int[l+1][m+1][n+1];
        for (int i = 1; i <= l; i++) {
            String curr = strs[i-1];
            int a = 0, b = 0;
            for (int t = 0; t < curr.length(); t++) {
                if (curr.charAt(t) == '0') {
                    a++;
                } else {
                    b++;
                }
            }

            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    int tmp = dp[i-1][j][k];
                    if (j-a >= 0 && k-b >= 0) {
                        if (tmp < dp[i-1][j-a][k-b] + 1) {
                            tmp = dp[i-1][j-a][k-b] + 1;
                        }
                    }
                    dp[i][j][k] = tmp;
                }
            }
        }
        return dp[l][m][n];
    }
}