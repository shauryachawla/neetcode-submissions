class Solution {
    public int longestConsecutive(int[] nums) {
        List<Integer> list = Arrays.stream(nums).boxed().sorted().distinct().collect(Collectors.toList());
        System.out.println(list);
        int result = 0;
        int currMax = 1;
        if(list.isEmpty()) return 0;
        for(int i=1;i<list.size();i++) {
            if(list.get(i) == list.get(i-1) + 1)
                currMax++;
            else{
                result = Math.max(result, currMax);
                currMax = 1;
                }
        }
        result = Math.max(result, currMax);
        return result;
    }
}
