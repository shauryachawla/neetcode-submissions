class Solution {

    boolean dfs(int course, Map<Integer, List<Integer>> prereq, Set<Integer> visit, Set<Integer> cycle, List<Integer> output) {
        if(cycle.contains(course)) return false;
        if(visit.contains(course)) return true;
        cycle.add(course);
        for(int pre: prereq.get(course)) {
            if(!dfs(pre, prereq, visit, cycle, output))
                return false;
        }
        cycle.remove(course);
        visit.add(course);
        output.add(course);
        return true;
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        IntStream.range(0, numCourses).forEach(i->map.put(i, new ArrayList<>()));
        for(int[] pair : prerequisites) {
            int c = pair[0];
            int p = pair[1];
            map.get(c).add(p);
        }
        List<Integer> list = new ArrayList<>();
        Set<Integer> visit = new HashSet<>();
        Set<Integer> cycle = new HashSet<>();
        for(var entry : map.entrySet()) {
            int course = entry.getKey();
            if(!dfs(course, map, visit, cycle, list))
                return new int[0];
        }
        int[] result = new int[numCourses];
        for(int i=0;i<numCourses;i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
