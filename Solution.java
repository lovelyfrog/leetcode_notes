class Solution {
    List<Character> leaf = new LinkedList<>();
    List<Integer> num = new LinkedList<>();
    public int minimumOperations(String leaves) {
        int i = 0;
        int n = leaves.length();
        while (i < n) {
            int cnt = 0;
            if (leaves.charAt(i) == 'r') {
                while (i < n && leaves.charAt(i) == 'r') {
                    i++;
                    cnt++;
                }
                leaf.add('r');
                num.add(cnt);
            } else {
                while (i < n && leaves.charAt(i) == 'y') {
                    i++;
                    cnt++;
                }
                leaf.add('y');
                num.add(cnt);
            }
        }
        if (check(leaf)) return 0;
        int ans = 0;
        if (leaf.get(0) != 'r') {
            leaf.add(0, 'r');
            num.add(0, 1);
            num.set(1, num.get(1)-1);
            ans++;
        }
        if (leaf.get(leaf.size()-1) != 'r') {
            leaf.add('r');
            num.add(1);
            num.set(leaf.size()-2, num.get(leaf.size()-2)-1);
            ans++;
        }
        int yNum = 0, rNum = 0;
        int yMax = 0;
        for (int j = 1; j < leaf.size()-1; j++) {
            if (leaf.get(j) == 'y') {
                yNum += num.get(j);
                yMax = Math.max(yMax, num.get(j));
            } else {
                rNum += num.get(j);
            }
        }
        if (yNum == 0) {
            ans += rNum;
        }else {
            ans += Math.min(rNum, yNum - yMax);
        }
        return ans;
    }
    public boolean check(List<Character> leaf) {
        if (leaf.size() == 3) {
            if (leaf.get(0) == 'r' && leaf.get(1) == 'y' && leaf.get(2) == 'r') return true;
        }
        return false;
    }   
}