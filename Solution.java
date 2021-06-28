class Solution {
    HashMap<Integer, List<Integer>> map;
    HashMap<Integer, Integer> visitedRoute;
    HashMap<Integer, Integer> visitedStop;
    Queue<Pair<Integer, Integer>> queue;
    public int numBusesToDestination(int[][] routes, int source, int target) {
        map = new HashMap<>();
        int l = routes.length;
        visitedRoute = new HashMap<>();
        visitedStop = new HashMap<>();
        queue = new LinkedList<>();
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < routes[i].length; j++) {
                if (!map.containsKey(routes[i][j])) {
                    List<Integer> tmp = new LinkedList<>();
                    tmp.add(i);
                    map.put(routes[i][j], tmp);
                } else {
                    List<Integer> tmp = map.get(routes[i][j]);
                    tmp.add(i);
                }
            }
        }

        List<Integer> curr = map.get(source);
        for (int i = 0; i < curr.size(); i++) {
            int route = curr.get(i);
            visitedRoute.put(route, 0);
            for (int j = 0; j < routes[route]; j++) {
                if (!visitedStop.containsKey(routes[route][j])) {
                    queue.offer(new Pair<Integer, Integer>(routes[route][j], 1));
                    visitedStop.put(routes[route][j], 0);
                    if (target == routes[route][j]) return 1;
                }
            }
        }

        while (!queue.isEmpty()) {
            Pair<Integer, Integer> tmp = queue.poll();
            int currStop = tmp.getKey();
            curr = map.get(currStop);
            for (int i = 0; i < curr.size(); i++) {
                int route = curr.get(i);
                if (visitedRoute.containsKey(route)) continue;
                visitedRoute.put(route, 0);
                for (int j = 0; j < routes[route]; j++) {
                    if (!visitedStop.containsKey(routes[route][j])) {
                        queue.offer(new Pair<Integer, Integer>(routes[route][j], tmp.getValue()+1));
                        visitedStop.put(routes[route][j], 0);
                        if (target == routes[route][j]) return tmp.getValue()+1;
                    }
                }
            }

        }

        return -1;

    }
}