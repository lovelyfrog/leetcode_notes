class Solution {
    List<List<String>> ans;
    HashMap<List<String>, Integer> map;
    public List<List<String>> solveNQueens(int n) {
        ans = new LinkedList<>();
        map = new HashMap<>();
        int[][] square = new int[n][n];
        for (int i = 0; i < n; i++) {
            dfs(square, 0, i, n);
        }
        return ans;
    }
    public void dfs(int[][] square, int x, int y, int n) {
        set(square, x, y, 0, n);
        if (n == 1) {
            List<String> tmp = new LinkedList<>();
            for (int i = 0; i < square.length; i++) {
                StringBuffer sb = new StringBuffer();
                for (int j = 0; j < square.length; j++) {
                    if (square[i][j] > 0) {
                        sb.append('Q');
                    } else {
                        sb.append('.');
                    }
                }
                tmp.add(sb.toString());
            }
            if (!map.containsKey(tmp)) {
                ans.add(tmp);
                map.put(tmp, 0);
            }
        }
        int j = 0;
        if (x + 1 < square.length) {
            while (j < square.length) {
                if (square[x+1][j] == 0) dfs(square, x+1, j, n-1);
                j++;
            }
        }
        set(square, x, y, -n, 0);
    }
    public void set(int[][] square, int x, int y, int originValue, int setValue) {
        square[x][y] = setValue;
        for (int i = 0; i < square.length; i++) {
            if (square[x][i] == originValue) square[x][i] = -setValue;
            if (square[i][y] == originValue) square[i][y] = -setValue;
        }
        for (int i = 1; i < square.length; i++) {
            if (x-i >= 0 && x-i < square.length && y-i >= 0 && y-i < square.length) {
                if (square[x-i][y-i] == originValue) square[x-i][y-i] = -setValue;
            }
            if (x+i >= 0 && x+i < square.length && y+i >= 0 && y+i < square.length) {
                if (square[x+i][y+i] == originValue) square[x+i][y+i] = -setValue;
            }
            if (x-i >= 0 && x-i < square.length && y+i >= 0 && y+i < square.length) {
                if (square[x-i][y+i] == originValue) square[x-i][y+i] = -setValue;
            }
            if (x+i >= 0 && x+i < square.length && y-i >= 0 && y-i < square.length) {
                if (square[x+i][y-i] == originValue) square[x+i][y-i] = -setValue;
            }
        }
    }
}
