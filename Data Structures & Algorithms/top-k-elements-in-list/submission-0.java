class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // -1000 < input < 1000
        // sanitize input
        // keep array to store count
        // iterate + incremenet counts

        int[] counts = new int[2001];
        for(var i: nums) {
            var sanitizedi = i+1000;
            counts[sanitizedi]++;
        }
        
        List<Pair<Integer, Integer>> countList = new ArrayList<>();
        for(int i=0; i < 2001; i++) {
            if(counts[i]>0) {
                countList.add(new Pair<Integer, Integer>(i-1000, counts[i]));
            }
        }
        countList.sort((a,b) -> b.getValue() - a.getValue());
        int[] result = new int[k];
        for(int i=0; i<k;i++) {
            result[i] = countList.get(i).getKey();
        }
        return result;
    }
}
