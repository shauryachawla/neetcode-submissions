class Solution {
    public static String minWindow(String s, String t) {
        Map<Character, Integer> tMap = new HashMap<>();
        for(char c: t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }
        int l=0, r=0, min=Integer.MAX_VALUE;
        int start=-1, end=-1;
        Map<Character, Integer> sMap = new HashMap<>();
        while(r < s.length()) {
            if(tMap.containsKey(s.charAt(r)))
                sMap.put(s.charAt(r), sMap.getOrDefault(s.charAt(r), 0) + 1);
            while(validCondition(sMap, tMap)) {
                // update result
                // shrink from left
                if(r-l+1 < min) {
                    min = r - l + 1;
                    start = l;
                    end = r;
                }
                if(tMap.containsKey(s.charAt(l)))
                    sMap.put(s.charAt(l), sMap.get(s.charAt(l)) -1);
                l++;
            }
            r++;

        }
        if(start == -1) return "";
        return s.substring(start, end+1);
        // make window.
        // while -->
        // expand until all elems from t are part of window.
        // update result.
        // shrink from left until condition no longer valid. keep updating rsult.

    }

    public static boolean validCondition(Map<Character, Integer> s, Map<Character, Integer> t) {
        for(var e: t.entrySet()) {
            Character c = e.getKey();
            Integer expectedCount = e.getValue();
            if(!s.containsKey(c)) return false;
            if(s.get(c) < expectedCount) return false;
        }
        return true;
    }
}
