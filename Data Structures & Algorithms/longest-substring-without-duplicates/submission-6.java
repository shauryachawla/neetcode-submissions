class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l=0,r=0;
        int result = 0;
        Set<Character> seen = new HashSet<>();
        while(r<s.length()) {
            while(r<s.length() && seen.contains(s.charAt(r))) {
                result = Math.max(result, r-l);
                seen.remove(s.charAt(l++));
            }
            seen.add(s.charAt(r));
            r++;
        }
        result = Math.max(result, r-l);
        return result;
    }
}
