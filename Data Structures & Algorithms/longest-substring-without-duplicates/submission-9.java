class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> seen = new HashSet<>();
        int l=0, r=0;
        int result = 0;
        while(r<s.length()) {
            char c = s.charAt(r);
            while(seen.contains(c)) {
                result = Math.max(result, r-l);
                seen.remove(s.charAt(l++));
            }
            seen.add(c);
            r++;
        }
        return Math.max(result, r-l);
    }
}
