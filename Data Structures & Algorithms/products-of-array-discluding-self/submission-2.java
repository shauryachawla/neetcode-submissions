class Solution {
    public int[] productExceptSelf(int[] nums) {
        var multiplyAll = Arrays.stream(nums).reduce(1, (a,x)->a*x);
        var zeroResult = Arrays.stream(nums).filter(x->x!=0).reduce(1, (a,x)->a*x);
        var moreThanOneZero = Arrays.stream(nums).filter(z->z==0).count() > 1;

        List<Integer> resultList = new ArrayList<>();
        Arrays.stream(nums).map(x->
            {
                if(x==0){
                    return moreThanOneZero ? 0 : zeroResult;
                }
                return multiplyAll/x;
            }
            ).forEach(x->resultList.add(x));
        return resultList.stream().mapToInt(Integer::intValue).toArray();
    }
}  
