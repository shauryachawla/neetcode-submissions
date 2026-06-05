class Solution {
    public int characterReplacement(String s, int k) {
        int l=0,r=0;
        Map<Character, Integer> map = new HashMap<>();
        int maxF = 0;
        int result = 0;
        while(r < s.length()) {
            char c = s.charAt(r);
            map.put(c, map.getOrDefault(c, 0) + 1);
            maxF = Math.max(maxF, map.get(c));
            // condition
            if(r-l-maxF+1 > k) {
                // shrink
                result = Math.max(result, r-l);
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                l++;
            }
            r++;
        }
        return Math.max(result, r-l);
    }
}
