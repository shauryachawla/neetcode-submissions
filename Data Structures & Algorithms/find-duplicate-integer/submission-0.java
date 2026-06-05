class Solution {
    public int findDuplicate(int[] nums) {
        int[] dict = new int[nums.length + 1];
        for(int num : nums) {
            if(dict[num] == 1) return num;
            dict[num] = 1;
        }
        return 0;
    }
}
