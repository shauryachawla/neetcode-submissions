class KthLargest {
    PriorityQueue<Integer> q = new PriorityQueue<>();
    int k = 0;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        for(int n : nums) {
            q.add(n);
            if(q.size() > k) 
                q.poll();
        }
    }
    
    public int add(int val) {
        q.add(val);
        if(q.size() > k)
            q.poll();
        return q.peek();
    }
}
