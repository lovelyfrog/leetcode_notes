class Solution {
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int l = group.length;
        int allSum = 0;
        for (int i = 0; i < l; i++) {
            allSum += profit[i];            
        }

        int[][] former = new int[allSum+1][n+1];
        int[][] curr = new int[allSum+1][n+1];
        int ans = 0;
        int max_value = (int)(1e9) + 7;

        if (minProfit == 0) ans++;

        for (int i = 1; i <= l; i++) {
            for (int j = allSum; j >= 0; j--) {
                for (int k = n; k >= 0; k--) {
                    curr[j][k] = former[j][k];
                    if (j-profit[i-1] >= 0 && k-group[i-1] >= 0) {
                        curr[j][k] = (curr[j][k] + former[j-profit[i-1]][k-group[i-1]]) % max_value;
                        if (j-profit[i-1] == 0 && k-group[i-1] == 0) {
                            curr[j][k] += 1;
                        }
                    }
                    if (i == l && j >= minProfit) {
                        ans += curr[j][k];
                        if (ans >= max_value) ans = ans % max_value;
                        
                    }

                }
            }
            former = curr;
        }
        
        return ans;
    }
}                                                                                                                                                                                                                                                                                                       