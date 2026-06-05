class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> seen = new HashSet<>();
        int maxLen = 0;
        int l = 0,r=0;
        char[] chars = s.toCharArray();
        while(r<chars.length) {
            while(seen.contains(chars[r])) {
                seen.remove(chars[l]);
                l++;
            }
            seen.add(chars[r]);
            maxLen = Math.max(maxLen, r-l+1);
            r++;
        }
        return maxLen;
        

    }
}
