class Solution {
    public int search(int[] nums, int target) {
        int index = search(nums, target, 0, nums.length-1);
        return index;
    }

    int search(int[] nums, int target, int start, int end) {
        int mid = start + ((end - start)/2 );
        if(start == end) {
            if(target == nums[mid]) return mid;
            else return -1;
        }
        else if(target > nums[mid])
            return search(nums, target, mid+1, end);
        else return search(nums, target, start, mid);
    }
}
