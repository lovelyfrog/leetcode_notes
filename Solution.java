class Solution {
    HashMap<Integer, Integer> map = new HashMap<>();
    class Node {
        int value;
        int number;
        Node(int value, int number) {
            this.value = value;
            this.number = number;
        }
    }
    static Comparator<Node> cNode = new Comparator<>() {
        public int compare(Node p1, Node p2) {
            return p2.number - p1.number;
        }
    }; 
    public int[] topKFrequent(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i])+1);
            }
        }
        Node[] nodes = new Node[map.size()];
        Set<Integer> keys = map.keySet();
        PriorityQueue<Node> heap = new PriorityQueue<>(cNode);
        int j = 0;
        for (Integer key: keys) {
            nodes[j] = new Node(key, map.get(key));
            heap.offer(nodes[j]);
            j++;
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = heap.poll().value;
        }
        return ans;
    }
}
