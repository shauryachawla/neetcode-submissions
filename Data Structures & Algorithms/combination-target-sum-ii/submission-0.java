class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(result, candidates, 0, target, new ArrayList<>());
        return result;
    }

    void dfs(List<List<Integer>> result, int[] nums, int i, int target, List<Integer> subset) {
        if(target == 0) {
            result.add(new ArrayList<>(subset));
            return;
        }
        if(i >= nums.length || target < 0) return;
        subset.add(nums[i]);
        dfs(result, nums, i+1, target - nums[i], subset);
        subset.remove(subset.size() - 1);
        while(i+1 < nums.length && nums[i] == nums[i+1]) 
            i++;
        dfs(result, nums, i+1, target, subset);
    }
}
