class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num: nums) {
            set.add(num);
        }
        int result = 0;
        for(int num : set) {
            if(!set.contains(num-1)) {
                int longest = 1;
                while(set.contains(num+1)) {
                    longest++;
                    num++;
                }
                result = Math.max(result, longest);
            }
        }
        return result;
    }
}
