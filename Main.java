import java.util.Scanner;
import java.util.LinkedList;
import java.util.List;
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int k = sc.nextInt();
        int numOfX = 0;
        int numOfOne = 0;
        List<Integer> ll = new LinkedList<>();
        while (x != 0) {
            int tmp = x % 10;
            x = (x - tmp) / 10;
            numOfX++;
            if (tmp == 1) numOfOne++;
            ll.add(tmp);
        }

        List<Integer> ans = new LinkedList<>();
        // 3 situations
        if (k < numOfOne) {
            ans.add(1);
            for (int i = 0; i < numOfX; i++) {
                ans.add(0);
            }

        } else if (k <= numOfX) {
            if (k == numOfOne) {
                int flag = 0;
                for (int i = 0; i < ll.size(); i++) {
                    if (flag == 0 && ll.get(i) == 0) {
                        continue;
                    }
                    if (flag == 1 && ll.get(i) == 0) {
                        ll.set(i, 1);
                        ll.set(i-1, 0);
                        break;
                    }
                    if (flag == 0 && ll.get(i) == 1) {
                        flag = 1;
                    }
                }
                if (flag == 0) {
                    ans.add(1);
                    for (int i = 0; i < numOfX - numOfOne + 1; i++) {
                        ans.add(0);
                    }
                    for (int i = 0; i < k-1; i++) {
                        ans.add(1);
                    }
                } else {
                    for (int i = ll.size()-1; i >= 0; i--) {
                        ans.add(ll.get(i));
                    }
                }
            } else {
                int cnt = 0;
                for (int i = 0; i < ll.size(); i++) {
                    if (ll.get(i) == 0) {
                        ll.set(i, 1);
                        cnt++;
                    }
                    if (cnt + numOfOne == k) break;
                }

                for (int i = ll.size()-1; i >= 0; i--) {
                    ans.add(ll.get(i));
                }
            }
            
        } else {
            for (int i = 0; i < k; i++) {
                ans.add(1);
            }
        }

        for (int i = 0; i < ans.size(); i++) {
            System.out.printf("%d", ans.get(i));
        }
        System.out.println();
    }
}