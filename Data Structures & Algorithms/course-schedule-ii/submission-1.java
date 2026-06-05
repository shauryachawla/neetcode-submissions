class Solution {

    public boolean dfs(int course, Map<Integer, List<Integer>> prereq, Set<Integer> visit, Set<Integer> cycle, List<Integer> output) {
        if(cycle.contains(course)) return false;
        if(visit.contains(course)) return true;
        cycle.add(course);
        for(int c: prereq.get(course)) {
            if(!dfs(c, prereq, visit, cycle, output))
                return false;
        }
        cycle.remove(course);
        visit.add(course);
        output.add(course);
        return true;
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> prereq = new HashMap<>();
        IntStream.range(0, numCourses).forEach(i->prereq.put(i, new ArrayList<>()));
        for(int[] pair: prerequisites) {
            int course = pair[0];
            int pre = pair[1];
            prereq.get(course).add(pre);
        }
        List<Integer> output = new ArrayList<>();
        Set<Integer> visit = new HashSet<>();
        Set<Integer> cycle = new HashSet<>();
        for(int course: prereq.keySet()) {
            if(!dfs(course, prereq, visit, cycle, output))
                return new int[0];
        }
        int[] result = new int[numCourses];
        IntStream.range(0, numCourses).forEach(i->result[i] = output.get(i));
        return result;
    }
}
