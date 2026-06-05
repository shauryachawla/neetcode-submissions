class Solution {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int[] count = new int[26];
        for(char task : tasks) {
            count[task - 'A']++;
        }
        for(int c : count) {
            if(c > 0)
                pq.add(c);
        }
        int time = 0;
        Queue<int[]> cooldown = new LinkedList<>();
        while(!pq.isEmpty() || !cooldown.isEmpty()) {
            time++;
            if(pq.isEmpty()) {
                
            } else {
                int cnt = pq.poll() - 1;
                if(cnt > 0) {
                    cooldown.add(new int[]{cnt, time + n});
                }
            }

            if(!cooldown.isEmpty() && cooldown.peek()[1] == time) {
                pq.add(cooldown.poll()[0]);
            }
        }
        return time;
    }
}
