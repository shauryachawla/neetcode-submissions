class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int l=0,r=0;
        int result = 0;
        int maxF = Integer.MIN_VALUE;
        while(r < s.length()) {
            char c = s.charAt(r);
            map.put(c, map.getOrDefault(c, 0) + 1);
            maxF = Math.max(map.get(c), maxF);
            // r-l -> len with extra letter.
            // maxF -> max occurance letter freq
            // r - l - maxF + 1 = how many char substitutions will be required.
            if(r-l-maxF >= k) {
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
