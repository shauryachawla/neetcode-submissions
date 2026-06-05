class Solution {
    public int lastStoneWeight(int[] stones) {
        var q = new PriorityQueue<Integer>((a,b) -> b-a);
        Arrays.stream(stones).boxed().forEach(q::add);
        while(q.size() != 1) {
            int x = q.poll();
            int y = q.poll();
            var diff = x-y;
            if(diff != 0) {
                q.add(diff);
            } else if(q.isEmpty())
                return 0;
        }
        return q.peek();
    }
}
