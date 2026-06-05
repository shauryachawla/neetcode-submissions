class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.stream(nums).forEach(num->map.put(num, map.getOrDefault(num, 0) + 1));
        System.out.println(map);
        var list = map.entrySet().stream().sorted((a,b)->b.getValue()-a.getValue()).map(e->e.getKey()).limit(k).collect(Collectors.toList());
        int[] result = new int[list.size()];
        for(int i=0;i<list.size();i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
