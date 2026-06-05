class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l=0;
        int res=0;
        Set<Character> seen = new HashSet<>();
        for(int r=0; r<s.length(); r++) {
            // left se chalo
            // jab tak charAt r nahi milta tab tak delete charAt l from set
            // ex - abcb ->> second b aane pe start ke a and b delete karoge.
            while(seen.contains(s.charAt(r))) {
                seen.remove(s.charAt(l));
                l++;
            }
            seen.add(s.charAt(r));
            res = Math.max(res, r-l +1);
        }
        return res;
    }
}
