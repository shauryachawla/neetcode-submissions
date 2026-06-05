class Solution {
    public int lengthOfLongestSubstring(String s) {
        int length = 0;
        int l=0, r=0;
        while(r< s.length()) {
            Set<Character> seen = new HashSet<>();
            while(r < s.length() && !seen.contains(s.charAt(r))) {
                seen.add(s.charAt(r++));
            }
            length = Math.max(length, r-l);
            l++; r= l;
        }
        return length;
    }
}
