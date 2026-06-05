class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(var num : nums) {
            if(map.containsKey(num))
                map.put(num, map.get(num) + 1);
            else
                map.put(num, 1);
        }
        var pq = new PriorityQueue<int[]>((a,b) -> b[1] - a[1]);
        for(var entry : map.entrySet()) {
            pq.offer(new int[]{entry.getKey(), entry.getValue()});
        }
        System.out.println(map);
        int[] result = new int[k];
        for(int i=0;i<k;i++) {
            result[i] = pq.poll()[0];
        }
        System.out.println(result);
        return result;
    }
}
