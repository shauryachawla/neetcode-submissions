class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int i =0;
        while(i<nums.length && nums[i] <= 0) {
            int l=i+1, r=nums.length-1;
            while(l<r) {
                int sum = nums[i] + nums[l] + nums[r];
                if(sum < 0)
                    l++;
                else if (sum > 0) {
                    r--;
                } else {
                    result.add(List.of(nums[i], nums[l++], nums[r--]));
                }
            }
            i++;
        }
        return result.stream().distinct().collect(Collectors.toList());

    }
}
