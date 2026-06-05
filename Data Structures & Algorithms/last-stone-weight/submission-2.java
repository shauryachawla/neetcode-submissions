class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Arrays.stream(stones).boxed().forEach(pq::add);
        while(pq.size() > 1) {
            int x = pq.poll();
            int y = pq.poll();
            if(x-y > 0) pq.add(x-y);
        }
        return pq.isEmpty()?0:pq.poll();
        
    }
}
