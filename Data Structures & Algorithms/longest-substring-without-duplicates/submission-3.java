class Solution {
    public int lengthOfLongestSubstring(String s) {
        int length = 0;
        int l=0, r=0;
        Set<Character> seen = new HashSet<>();
        while(r< s.length()) {
            while(r < s.length() && seen.contains(s.charAt(r))) {
                seen.remove(s.charAt(l++));
                // r++;
            }
            seen.add(s.charAt(r));
            length = Math.max(length, r-l+1);
            r++;
        }
        return length;
    }
}
