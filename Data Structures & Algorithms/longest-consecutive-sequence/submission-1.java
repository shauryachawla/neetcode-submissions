class Solution {
    public int longestConsecutive(int[] nums) {
        // Sort the array.
        // filter dupes
        // calculate 
        if(nums.length == 0) return 0;
        var sortedAndDedupedNums = Arrays.stream(nums).sorted().distinct().boxed().collect(Collectors.toList());
        
        int maxCount = 1;
        int count = 1;
        for(int i=1;i<sortedAndDedupedNums.size();i++) {
            // count should be init here.
            if(sortedAndDedupedNums.get(i) == sortedAndDedupedNums.get(i-1) + 1) count++;
            else {
                maxCount = Math.max(maxCount, count);
                count = 1;
            }
        }
        maxCount = Math.max(maxCount, count);
        return maxCount;
    }
}
