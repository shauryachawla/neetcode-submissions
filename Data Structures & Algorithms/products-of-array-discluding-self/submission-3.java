class Solution {
    public int[] productExceptSelf(int[] nums) {
        int allProduct = IntStream.of(nums).reduce(1, (a,x) -> a*x);
        int productWithoutZeroes = IntStream.of(nums).filter(x->x!=0).reduce(1, (a,x) -> a*x);
        boolean moreThanOneZero = IntStream.of(nums).filter(x->x==0).count() > 1;
        int[] result = new int[nums.length];
        
        for(int i=0; i<nums.length;i++) {
            if(nums[i] == 0)
                result[i] = moreThanOneZero? 0 : productWithoutZeroes;
            else 
                result[i] = allProduct/nums[i];
        }
        return result;
    }
}  
