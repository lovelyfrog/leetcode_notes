class Solution {
    public int breakfastNumber(int[] staple, int[] drinks, int x) {
        int m = staple.length;
        int n = drinks.length;
        int mod = (int)1e9 + 7;
        Arrays.sort(staple);
        Arrays.sort(drinks);
        int ans = 0;
        int j = n-1;
        for (int i = 0; i < m; i++) {
            if (j < 0) break;
            if (staple[i] > x) break;
            int index = find(drinks, 0, j, x - staple[i]);
            j = index - 1;
            if (j >= 0) ans = (ans + j + 1) % mod;
        }
        return ans;
    }
    public int find(int[] drinks, int i, int j, int left) {
        // 找到drinks在i,j中第一个大于left的索引。
        if (drinks[j] <= left) return j+1;
        if (drinks[i] > left) return i;
        int middle = (i + j) / 2;
        if (drinks[middle] <= left) return find(drinks, middle+1, j, left);
        return find(drinks, i, middle, left);

    }
}