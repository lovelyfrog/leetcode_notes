class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int l = nums.length;
        int allSum = 0;
        for (int i = 0; i < l; i++) {
            allSum += nums[i] > 0?nums[i]: -nums[i];
        }

        if (target < -allSum || target > allSum) {
            return 0;
        }


        int[][] dp = new int[l+1][2*allSum+1];
        int newTarget = target + allSum;
        if (nums[0] != 0) {
            dp[1][0] = 1;
            dp[1][2*nums[0]] = 1;
        } else {
            dp[1][0] = 2;
        }


        for (int i = 2; i <= l; i++) {
            for (int j = 0; j < 2*allSum+1; j++) {
                dp[i][j] = dp[i-1][j];
                if (j-2*nums[i-1] >= 0) {
                    dp[i][j] += + dp[i-1][j-2*nums[i-1]];
                }
            }
        }

        return dp[l][newTarget];
    }
}