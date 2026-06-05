class Solution {

    public static boolean compareMap(Map<Character, Integer> map1, Map<Character, Integer> map2) {
        boolean result = false;
        // compare size
        boolean sameSize = map1.size() == map2.size();
        // compare key-values
        boolean sameKeyvalues = false;
        for(var pair: map1.entrySet()) {
            if(!map2.containsKey(pair.getKey())) return false;
            else {
                if(pair.getValue() != map2.get(pair.getKey())) return false;
            }
        }
        sameKeyvalues = true;
        return sameSize && sameKeyvalues;
    }

    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();
        for(var c: s.toCharArray()) {
            sMap.put(c, sMap.getOrDefault(c, 0) + 1);
        }
        for(var c: t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }
        return sMap.equals(tMap);
    }

    
}
