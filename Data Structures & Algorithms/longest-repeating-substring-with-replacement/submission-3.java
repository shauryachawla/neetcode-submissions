class Solution {
    public int characterReplacement(String s, int k) {
            // sliding window
            Map<Character, Integer> map = new HashMap<>();
            int l=0,r=0;
            int maxF = 0;
            int result = Integer.MIN_VALUE;
            while(r < s.length()) {
                // update
                map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0)+1);
                maxF = Math.max(maxF, map.get(s.charAt(r)));
                // check whether we're out of tries/not.
                // r-l+1 --> len of our window. 
                // maxF --> len of max occuring char. 
                // difference --> how many chars we need to replace.
                if(r-l+1 - maxF <=k) {
                    
                } else {
                    result = Math.max(result, r-l);
                    map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                    l++;
                }
                // add
                r++;
            }
            result = Math.max(result, r-l);
            return result;
    }
}
