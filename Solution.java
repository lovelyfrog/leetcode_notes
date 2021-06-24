class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length;
        double[][] g = new double[n][n];
        if (n == 1) return 1;

        int ans = 2;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (points[i][0] - points[j][0] == 0) {
                    g[i][j] = 1e6;
                    g[j][i] = g[i][j];
                    continue;
                }
                g[i][j] = (double) (points[i][1] - points[j][1]) / (points[i][0] - points[j][0]);
                g[j][i] = g[i][j];

            }
        }

        for (int i = 0; i < n; i++) {
            HashMap<Double, Integer> map = new HashMap<>();
            for (int j = 0; j < n; j++) {
                if (j == i) continue;
                if (!map.containsKey(g[i][j])) {
                    map.put(g[i][j], 2);
                } else {
                    int tmp = map.get(g[i][j]);
                    map.put(g[i][j], tmp+1);
                    if (ans < tmp+1) {
                        ans = tmp+1;
                    }

                }
            }
        }
        return ans;
    }
}