class Solution {
    public boolean isPalindrome(String s) {
        /*
        1. maintain start, end pointers; 
        2. while start < end
        3. if(charAt(start) != charAt(end)) return false
        4. return true;
        */
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        
        int start=0, end=s.length()-1;
        while(start<end) {
            if(s.charAt(start++) != s.charAt(end--)) return false;
        }
        
        return true;
    }
}
