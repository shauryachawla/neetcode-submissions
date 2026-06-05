class Solution {
    public int findKthLargest(int[] nums, int k) {
        var q = new PriorityQueue<Integer>();
        
        for(var i : nums) {
            q.offer(i);
            if(q.size() > k) 
                q.poll();
        }
        return q.peek();
    }
}
