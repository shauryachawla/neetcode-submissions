class Solution {

    class Box {
        Integer value;
        Integer count;

        public Box(Integer value, Integer count) {
            this.value = value;
            this.count = count;
        }

        @Override
        public String toString() {
            return "{"+"Value:"+value+" Count:" +count +"}";
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        Arrays.sort(nums);
        Map<Integer, Long> map = Arrays.stream(nums).boxed().collect(Collectors.groupingBy(
            java.util.function.Function.identity(),
            Collectors.counting()
        ));
        List<Box> boxList = map.entrySet().stream()
        .map(s->
            new Box(s.getKey(), s.getValue().intValue())
        )
        .sorted((a,b) -> b.count - a.count)
        .collect(Collectors.toList());
        var resultList = boxList.subList(0,k);
        int[] result = new int[resultList.size()];
        for(int i=0;i<resultList.size();i++) {
            result[i] = resultList.get(i).value;
        }
        return result;
    }
}
