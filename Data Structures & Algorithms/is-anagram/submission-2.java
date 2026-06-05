class Solution {

    public boolean isAnagram(String s, String t) {
        var sMap = s.chars().mapToObj(c->(char) c).collect(Collectors.groupingBy(java.util.function.Function.identity(), Collectors.counting()));
        var tMap = t.chars()
        .mapToObj(c->(char) c)
        .collect(Collectors.groupingBy(
            java.util.function.Function.identity(),
            Collectors.counting()
        ));

        return sMap.equals(tMap);
    }
}
