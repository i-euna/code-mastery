class Solution {
    public boolean isValid(String s) {
        Stack<Character> parentheses = new Stack<Character>();
        for(int i = 0; i < s.length(); i++) {
            switch(s.charAt(i)) {
               case '(':
                   parentheses.push(')');
                   break;
               case '{':
                   parentheses.push('}');
                   break;
               case '[':
                   parentheses.push(']');
                   break;
               default:
                   if(parentheses.isEmpty() || parentheses.pop() != s.charAt(i))
                      return false;
                   break;
           }
        }
    return parentheses.isEmpty();
    }
}