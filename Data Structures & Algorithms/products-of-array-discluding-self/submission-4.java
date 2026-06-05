class Solution {
    public int[] productExceptSelf(int[] nums) {
        // prefix products banao
        int[] pre = new int[nums.length];
        pre[0] = 1;
        for(int i=1; i<pre.length;i++) {
            pre[i] = pre[i-1] * nums[i-1];
        }
        printArray(pre);
        int[] post = new int[nums.length];
        post[nums.length-1] = 1;
        for(int i=nums.length-2; i>=0;i--) {
            post[i] = post[i+1] * nums[i+1];
        }
        printArray(post);
        // dono ko multiply karo <-- result
        int[] result = new int[nums.length];
        for(int i=0;i<nums.length;i++) {
            result[i] = pre[i] * post[i];
        }

        return result;
    }
    
    void printArray(int[] arr) {
        System.out.print("[");
        for(var num: arr) {
            System.out.print(num + ",");
        }
        System.out.println("]");
    }
}  
