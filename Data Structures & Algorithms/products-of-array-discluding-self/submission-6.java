class Solution {
    public int[] productExceptSelf(int[] nums) {
        /*
        1. calculate left products.
        2. calculate right products.
        3. result is product of each index.
        */
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        int[] result = new int[nums.length];
        for(int i=0;i<nums.length;i++) {
            if(i==0) {
                left[i] = 1;
                continue;
            }
            left[i] = left[i-1] * nums[i-1];
        }
        for(int i=nums.length-1;i>=0;i--) {
            if(i==nums.length-1) {
                right[i] = 1;
                continue;
            }
            right[i] = right[i+1] * nums[i+1];
        }
        for(int i=0;i<nums.length;i++) {
            result[i] = left[i]*right[i];
        }
        return result;
    }
}  
