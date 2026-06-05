class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> valids = Map.of(
            ']', '[',
            ')', '(',
            '}', '{'
        );
        char[] tokens = s.toCharArray();
        Stack<Character> openStack = new Stack<>();
        for(var c : tokens) {
            switch(c) {
                case('('):
                case('{'):
                case('['):
                    openStack.push(c);
                    break;
                case(')'):
                case('}'):
                case(']'):
                    boolean isValid = checkValid(c, openStack, valids);
                    if(!isValid) return false;
                    break;
                default:
                    return false;
            }
        }
        return openStack.isEmpty();
    }

    boolean checkValid(Character c, Stack<Character> openStack, Map<Character, Character> valids) {
        if(openStack.isEmpty()) return false;
        Character topChar = openStack.pop();
        System.out.println("c = " + c + " topChar = " + topChar + " valids.get(c) = " + valids.get(c));
        return topChar.equals(valids.get(c));
    }
}
