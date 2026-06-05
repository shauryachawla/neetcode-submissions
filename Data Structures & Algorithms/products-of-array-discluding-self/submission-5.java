class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];

        int prod = 1;
        left[0] = 1;
        for(int i=1;i<left.length;i++) {
            left[i] = prod*nums[i-1];
            prod = left[i];
        }

        prod = 1;
        right[right.length-1] = 1;
        for(int i=right.length-2;i>=0;i--) {
            right[i] = prod*nums[i+1];
            prod = right[i];
        }

        int[] result = new int[nums.length];
        for(int i=0;i<nums.length;i++) {
            result[i] = left[i]*right[i];
        }
        return result;
    }

    public void printArray(int[] nums) {
        for(int i=0;i<nums.length;i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }
}  
