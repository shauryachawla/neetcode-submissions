class KthLargest {
    int k;
    PriorityQueue<Integer> pq = new PriorityQueue<>();

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for(int num: nums) {
            this.add(num);
        }
    }
    
    public int add(int val) {
        pq.add(val);
        if(pq.size() > k) {
            pq.poll();
        }
        return pq.peek();
    }
}
