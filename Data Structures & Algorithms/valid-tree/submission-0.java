class Solution {
    boolean dfs(int i, Map<Integer, List<Integer>> map, Set<Integer> visited, int prevNode) {
        if(visited.contains(i))
            return false;
        visited.add(i);
        for(int nei : map.get(i)) {
            if(nei == prevNode) continue;
            else if(!dfs(nei, map, visited, i))
                return false;
        }
        return true;
    }

    public boolean validTree(int n, int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        IntStream.range(0,n).forEach(i-> map.computeIfAbsent(i, k-> new ArrayList<>()));
        for(int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            map.get(a).add(b);
            map.get(b).add(a);
        }
        Set<Integer> visited = new HashSet<>();
        
        if(!dfs(0, map, visited, -1))
            return false;
        
        return visited.size() == n;
    }
}
