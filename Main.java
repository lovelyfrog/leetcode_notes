import java.util.*;
public class Main {

    public class Solution {
        public int MOD = (int) 1e9 + 7;

        public boolean isPrime(int number) {
            if (number == 1) return false;
            for (int i = 2; i * i <= number; i++) {
                if (number % i == 0) return false;
            }
            return true;
        }

        public int countPrimeStrings(String number) {
            int l = number.length();
            int[] dp = new int[l+1];
            dp[l] = 1;
            for (int i = l-1; i >= 0; i--) {
                for (int k = 1; k <= 6; k++) {
                    if (i + k > l) break;
                    String sub = number.substring(i, i+k);
                    int num = Integer.valueOf(sub);
                    if (isPrime(num))
                        dp[i] += dp[i+k];
                        dp[i] %= MOD;
                }
            }
            return dp[0];
        }
    }

    public void test() {
        Solution sol = new Solution();
        System.out.println(sol.countPrimeStrings("11373"));
        System.out.println(sol.countPrimeStrings("3175"));
    }

    public static void main(String[] args) {
        Main mm = new Main();
        mm.test();
    }
}
