class Solution {
    public String minWindow(String s, String t) {
        // find tMap;
        // make sMap
        // l and r
        
        Map<Character, Integer> tMap = new HashMap<>();
        Map<Character, Integer> sMap = new HashMap<>();
        for(char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c,0)+1);
        }
        int l=0,r=0;
        int start=0,end=-1;
        int minLen = Integer.MAX_VALUE;
        while(r<s.length()) {
            // add char to map
            if(tMap.containsKey(s.charAt(r)))
                sMap.put(s.charAt(r), sMap.getOrDefault(s.charAt(r), 0)+1 );
            // check if condition false
            while(validCondition(sMap, tMap)) {
                // update start, end
                if(r-l < minLen){
                    start = l;
                    end = r;
                    minLen = end - start;
                }
                // shrink window
                if(tMap.containsKey(s.charAt(l)))
                    sMap.put(s.charAt(l), sMap.get(s.charAt(l)) -1);
                l++;
            }
            r++;
        }
        return s.substring(start, end+1);
    }

    public boolean validCondition(Map<Character, Integer> sMap, Map<Character, Integer> tMap) {
        for(var e : tMap.entrySet()) {
            char c = e.getKey();
            Integer hits = e.getValue();
            if(!sMap.containsKey(c)) return false;
            if(sMap.get(c) < hits) return false;
        }
        return true;
    }
}
