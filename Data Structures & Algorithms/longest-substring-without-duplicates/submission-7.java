class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> seen = new HashSet<>();
        int l=0,r=0;
        int result = 0;
        while(r<s.length()) {
            // check
            while(r<s.length() && seen.contains(s.charAt(r))) {
                seen.remove(s.charAt(l++));
            }
            // update
            result = Math.max(result, r-l+1);
            // add
            seen.add(s.charAt(r++));
        }
        return result;
    }
}
