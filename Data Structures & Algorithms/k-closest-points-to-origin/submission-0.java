class Solution {
    PriorityQueue<int[]> q;
    int k;
    public int[][] kClosest(int[][] points, int k) {
        this.k = k;
        q = new PriorityQueue<int[]>((a, b) -> (distanceFromOrigin(b) - distanceFromOrigin(a)));
        for(int[] point : points) {
            q.offer(point);
            if(q.size() > k)
                q.poll();
        }
        int[][] result = new int[q.size()][];
        int counter = 0;
        while(!q.isEmpty()) {
            int[] point = q.poll();
            result[counter++] = point;
        }
        return result;
    }

    

    int distanceFromOrigin(int[] point) {
        return (point[0]*point[0] + point[1]*point[1]);
    }
}
