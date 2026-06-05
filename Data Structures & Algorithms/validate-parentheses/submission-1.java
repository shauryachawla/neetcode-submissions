class Solution {
    Map<Character, Character> map = Map.of(
            ')', '(',
            '}', '{',
            ']', '['
        );
    public boolean isValid(String s) {
        char[] charArr = s.toCharArray();
        
        var one = new Stack<>();
        
        for(Character c: charArr) {
            switch(c) {
                case('('):
                case('['):
                case('{'):
                    one.push(c);
                    break;
                case(')'):
                case('}'):
                case(']'):
                    if(one.isEmpty()) return false;
                    if(one.peek() != map.get(c)) return false;
                    one.pop();
                    break;
                default:
                    return false;
            }
        }
        if(!one.isEmpty()) return false;
        return true;
    }
}
