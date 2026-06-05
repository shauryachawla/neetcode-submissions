class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs) {
            char[] charr = str.toCharArray();
            Arrays.sort(charr);
            String code = new String(charr);
            if(map.containsKey(code)) {
                map.get(code).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(code, list);
            }
        }
        List<List<String>> result = new ArrayList<>();
        for(var entry : map.entrySet()) {
            result.add(entry.getValue());
        }
        return result;
    }
}
