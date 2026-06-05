class Solution {
    public int[] twoSum(int[] numbers, int target) {
        for(int i=0; i<=numbers.length-1; i++) {
            int a = numbers[i];
            int lookingFor = target - a;
            for(int j=i+1;j<=numbers.length-1;j++) {
                if(numbers[j] == lookingFor) return new int[]{i+1, j+1};
            }
        }
        return new int[] {0, 0};
    }
}
