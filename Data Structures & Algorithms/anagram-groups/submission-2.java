class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<Integer>> map = new HashMap<>();
        List<List<String>> result = new ArrayList<>();
        /*
        1. for each str 
            - calculate signature (key) and put index as (value)
        2. Iterate over map
            - group indexes present on same key.
        */
        for(int i=0;i<strs.length;i++) {
            String s = strs[i];
            char[] keyChar = s.toCharArray();
            Arrays.sort(keyChar);
            String key = new String(keyChar);
            map.computeIfAbsent(key, k -> new ArrayList<Integer>()).add(i);
        }
        for(var entry : map.entrySet()) {
            List<String> list = new ArrayList<>();
            entry.getValue().forEach(i->list.add(strs[i]));
            result.add(list);
        }
        return result;
    }
}
