class Solution {
    Map<Integer, List<Integer>> map = new HashMap<>();
    Set<Integer> visited = new HashSet<>();
    public boolean dfs(int crs) {
        if(visited.contains(crs)) return false;
        if(map.getOrDefault(crs, List.of()).isEmpty()) return true;
        visited.add(crs);
        for(int c: map.get(crs)) {
            if(!dfs(c)) return false;
        }
        visited.remove(crs);
        map.put(crs, List.of());
        return true;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for(int i=0;i<prerequisites.length;i++) {
            int crs = prerequisites[i][0];
            int pr = prerequisites[i][1];
            map.compute(crs, (k, v) -> {
                if(v == null) {
                    List<Integer> newList = new ArrayList<>();
                    newList.add(pr);
                    return newList;
                } else {
                    v.add(pr);
                    return v;
                }
            });
        }

        for(Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            Integer crs = entry.getKey();
            if(!dfs(crs)) return false;
        }

        return true;
    }
}
