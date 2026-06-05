class Solution {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    int k;
    public int findKthLargest(int[] nums, int k) {
        this.k = k;
        Arrays.stream(nums).boxed().forEach(this::add);
        System.out.println(pq);
        return pq.peek();
    }

    public void add(int x) {
        pq.offer(x);
        if(pq.size() > k)
            pq.poll();
    }
}
