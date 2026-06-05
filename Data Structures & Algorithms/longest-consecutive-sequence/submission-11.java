class Solution {
    public int longestConsecutive(int[] nums) {
        List<Integer> list = Arrays.stream(nums).boxed().sorted().distinct().collect(Collectors.toList());
        if(list.isEmpty()) return 0;
        int max = 0;
        int currMax = 1;
        for(int i=1;i<list.size();i++) {
            if(list.get(i) == list.get(i-1) + 1)
                currMax++;
            else {
                max = Math.max(max, currMax);
                currMax = 1;
            }
        }
        max = Math.max(max, currMax);
        return max;
    }
}
