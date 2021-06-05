**stack的用法**

`Deque<Integer> stack = new LinkedList<Integer>()`

后面的`LinkedList<Integer>()`可以简写成`LinkedList<>()`

```java
stack.peek();	//取队尾
stack.push(val);
stack.pop();
stack.isEmpty();
```

单调栈中保存的是index

**queue的用法**

```java
Queue<Integer> queue = new LinkedList<>();
queue.offer(val);
queue.poll();
queue.peek();	//取队头
```

**PriorityQueue**

```java
Comparator<Node> cNode = new Comparator<>() {
  public int compare(Node p1, Node p2) {
    return p2.number - p1.number;
  }
};
Queue<Node> pq = new PriorityQueue<>(comp);
Queue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());
```

**StringBuffer**

```java
StringBuffer sb = new StringBuffer();
sb.charAt(i);
sb.append(c);
sb.toString();
sb.length();
sb.delete(a, b);
```

**hashMap**

`HashMap<Integer, Integer> map = new HashMap<>();`

```java
map.containsKey(key);
map.put(key, val);
map.get(key);
```

**排序**

```java
int[] nums;
Arrays.sort(nums);
```

**List操作**

```java
List<Integer> list = new ArrayList<>();
List<Integer> list = new LinkedList<>();
List<Integer> list = new LinkedList<>(path);
list.add(val);
list.addLast(val);
list.add(pos, val);
list.set(pos, val);
list.get(pos);
```

**双指针**

一个指针在头，一个在尾，相向而行。

快慢指针，用来寻找中间值。

**acm模式输入输出**

```java
import java.util.Scanner;
public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
  }
}
// 输入
sc.hasNext();
sc.nextInt();
sc.nextDouble();
sc.next();	// for string
sc.nextLine();

// 输出
System.out.print();
System.out.println();
System.out.printf();
```

```java
import java.util.Scanner;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {
    
    static class Pair implements Comparable<Pair>{
        int x;
        int y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
        @Override
        public int compareTo(Pair other) {
            return this.x - other.x;
        }

    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        Pair[] set = new Pair[num];
        for (int i = 0; i < num; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            set[i] = new Pair(x, y);
        }
        Arrays.sort(set);
        
        List<Integer> ansIndexList = new LinkedList<>();
        for (int i = 0; i < num; i++) {
            if (ansIndexList.isEmpty()) {
                ansIndexList.add(i);
            } else {
                int index = ansIndexList.get(ansIndexList.size() - 1);
                while (set[i].y > set[index].y) {
                    ansIndexList.remove(ansIndexList.size() - 1);
                    if (ansIndexList.size() == 0) break;
                    index = ansIndexList.get(ansIndexList.size() - 1);
                }
                ansIndexList.add(i);
            }
        }
        
        for (int i = 0; i < ansIndexList.size(); i++) {
            int index = ansIndexList.get(i);
            System.out.printf("%d %d\n", set[index].x, set[index].y);
        }
    }
    
    
}
```

### 模版：

```java
import java.util.*;
class Solution {
    public ArrayList<Integer> nextPermutation(ArrayList<Integer> x) {
        int length = x.size();
        int i = length-2;
        while (i >= 0) {
            if (x.get(i) <= x.get(i+1)) {
                i--;
            } else {
                break;
            }
        }
        
        if (i == -1) {
            return x;
        }

        int j;
        int iValue = x.get(i);
        int currMax = x.get(i+1);
        int currIndex = i+1;
        for (j = i+1; j < length; j++) {
            if (x.get(j) < iValue && x.get(j) >= currMax) {
                currMax = x.get(j);
                currIndex = j;
            }
        }

        x.set(i, currMax);
        x.set(currIndex, iValue);
        int k = (length - i - 1) / 2;
        // System.out.println(k);
        for (j = 1; j <= k; j++) {
            int a = x.get(i+j);
            int b = x.get(length-j);
            x.set(i+j, b);
            x.set(length-j, a);
        }

        return x;
    }

    public static void main(String[] args) {
        ArrayList<Integer> x = new ArrayList<>();
        x.add(4);
        x.add(6);
        x.add(3);
        x.add(5);
        x.add(5);
        x.add(5);
        Solution sol = new Solution();  
        x = sol.nextPermutation(x);
        System.out.println(x);
    }

}    

