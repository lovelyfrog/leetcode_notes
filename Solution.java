class Solution {
    StringBuffer sb = new StringBuffer();
    HashMap<Integer, Integer> map = new HashMap<>();
    int[] factorial;
    public String getPermutation(int n, int k) {
        factorial = new int[n+1];
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            map.put(i, 1);
            factorial[i] = factorial[i-1] * i;
        }
        helper(n, k);
        return sb.toString();
    }

    public void helper(int n, int k) {
        if (n == 0) return;
        int length = map.size();
        int subFact = factorial[n-1];
        int first = (k-1) / subFact + 1;
        int rest = (k-1) % subFact + 1;
        for (int i = 1; i <= length; i++) {
            if (map.get(i) == 1) {
                first--;
                if (first == 0) {
                    sb.append((char)(i+'0'));
                    map.put(i, 0);
                }
            } 
        }
        helper(n-1, rest);
    }
}
