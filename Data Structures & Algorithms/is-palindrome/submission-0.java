class Solution {
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^\\w]","").toLowerCase();
        System.out.println(s);
        var strLen = s.length();
        int p1 = 0;
        int p2 = strLen - 1;
        while(p1 < p2) {
            if(s.charAt(p1) != s.charAt(p2)) {
                System.out.println(s.charAt(p1) + " is not equal to " + s.charAt(p2));
                return false;}
            p1++;p2--;
        }
        return true;
    }
}
