class Solution {
    int[][] dist;
    int[][][] memo;
    int n;
    int mod = (int)(1e9+7);
    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        n = locations.length;
        dist = new int[n][n];
        memo = new int[n][n][fuel+1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = Math.abs(locations[i] - locations[j]);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k <= fuel; k++) {
                    memo[i][j][k] = -1;
                }
            }
        }
        return helper(start, finish, fuel);
    }
    public int helper(int s, int t, int fuel) {
        if (memo[s][t][fuel] != -1) return memo[s][t][fuel];
        if (fuel == 0) {
            if (s == t) {
                memo[s][t][fuel] = 1;
                return 1;
            } else {
                memo[s][t][fuel] = 0;
                return 0;
            }
        } 
        int ret = 0;
        if (s == t) ret++;
        for (int i = 0; i < n; i++) {
            if (fuel >= dist[s][i] && i != s) {
                ret += helper(i, t, fuel-dist[s][i]);
                ret = ret % mod;
            }
        }
        memo[s][t][fuel] = ret;
        return ret;
    }
}
