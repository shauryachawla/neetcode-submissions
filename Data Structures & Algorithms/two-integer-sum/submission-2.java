class Solution {
    public int[] twoSum(int[] nums, int target) {
        /*
        1. Iterate over nums.
            - store (target - num) -> ix.
            - identify if map already has a num.
                - if yes then we found the pair. (i, ix)
        */
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int key = target - nums[i];
            if(map.containsKey(nums[i])) {
                return new int[]{map.get(nums[i]), i};
            }
            map.put(key, i);
        }
        return new int[]{};
    }
}
