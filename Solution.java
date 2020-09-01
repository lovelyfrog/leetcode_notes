class Solution {
    HashMap<String, PriorityQueue<String>> map = new HashMap<>();
    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> ans = new LinkedList<>();
        for (List<String> tmp: tickets) {
            if (!map.containsKey(tmp.get(0))) {
                map.put(tmp.get(0), new PriorityQueue<String>());
            }
            map.get(tmp.get(0)).offer(tmp.get(1));
        }
        dfs("JFK", ans);
        return ans.reverse();
    }
    public void dfs(String city, List<String> ans) {
        while (map.containsKey(city) && map.get(city).size() != 0) {
            dfs(map.get(city).poll(), ans);
        }
        ans.add(city);
    }
}