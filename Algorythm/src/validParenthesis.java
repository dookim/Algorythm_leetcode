import java.util.Stack;


public class validParenthesis {
	/*
	 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
		The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
	 */
    public boolean isValid(String s) {
    	
    	Stack<Character> stack = new Stack<>();
    	
    	for(int i = 0; i < s.length(); ++i) {
    		char ch = s.charAt(i);
    		if(ch == '(' || ch == '{' || ch == '[') {
    			stack.push(ch);
    		} else {
    			if(stack.size() == 0) return false;
    			char poped = stack.pop();
    			if(ch == ')' && !(poped == '(')) {
    				return false;
    			} else if(ch == '}' && !(poped == '{')) {
    				return false;
    			} else if(ch == ']' && !(poped == '[')) {
    				return false;
    			}
    		}
    	}
    	return stack.size() == 0;
    }
}
