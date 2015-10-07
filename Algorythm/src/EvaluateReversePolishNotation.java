import java.util.Stack;


public class EvaluateReversePolishNotation {
	
	/*
	 *   ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
	 */
	
    public int evalRPN(String[] tokens) {
    	Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < tokens.length; ++i) {
        	String cur = tokens[i];
        	if(cur.equals("+") || cur.equals("-") || cur.equals("*") || cur.equals("/")) {
        		int second = stack.pop();
        		int first = stack.pop();
        		int result = -1;
        		if(cur.equals("+")) {
        			result = first + second;
        		} else if(cur.equals("-")) {
        			result = first - second;
        		} else if(cur.equals("*")) {
        			result = first * second;
        		} else if(cur.equals("/")) {
        			result = first / second;
        		}
        		stack.push(result);
        	} else {
        		stack.push(Integer.parseInt(tokens[i]));
        	}
        }
        return stack.peek();
    }
    
    public static void main(String[] args) {
		EvaluateReversePolishNotation erpn = new EvaluateReversePolishNotation();
		String[] input = {"3", "-1","+"};
		System.out.println(erpn.evalRPN(input));
	}

}
