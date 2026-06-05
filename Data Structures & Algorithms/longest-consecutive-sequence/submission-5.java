class Solution {
    public int longestConsecutive(int[] nums) {
        // dedupe and sort.
        // start from beginning keep a count. 
        if(nums.length == 0) return 0;
        List<Integer> list = Arrays.stream(nums).distinct().sorted().boxed().collect(Collectors.toList());
        int max = 0;
        int currMax = 1;
        for(int i=0;i<list.size()-1;i++) {
            if(list.get(i) == list.get(i+1) - 1)
                currMax++;
            else {
                max = Math.max(max, currMax);
                currMax = 1;
            }
        }
        max = Math.max(currMax, max);
        return max;
    }
}
