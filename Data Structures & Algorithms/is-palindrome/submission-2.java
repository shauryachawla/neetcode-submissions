class Solution {
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^0-9A-Za-z]", "").toLowerCase();
        int start = 0 , end = s.length()-1;
        while(start < end) {
            if(s.charAt(start++) != s.charAt(end--)) return false;

        }
        return true;
    }
}
