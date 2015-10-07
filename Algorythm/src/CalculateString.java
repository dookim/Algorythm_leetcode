import java.util.Stack;


public class CalculateString {
	
	private static final int PLUS = 0;
	private static final int OPEN = 1;
	private static final int MINUS = 3;
	
	public static int calculate(String s) {
		Stack<Integer> operandStack = new Stack<Integer>();
		Stack<Integer> opcodeStack = new Stack<Integer>();
		
		int len = s.length();
		
		for(int i = 0; i < len; ++i) {
			char curChar = s.charAt(i);
			if(curChar == ' ') continue;
			else if(curChar == '+') opcodeStack.push(PLUS);
			else if(curChar == '-') {
				char nextChar = ' ';
				while((nextChar=s.charAt(++i)) == ' ');
				if(nextChar == '(') {
					opcodeStack.push(MINUS);
					opcodeStack.push(OPEN);
				} 
				//숫자인 경우.
				else {
					opcodeStack.push(PLUS);
					String val = nextChar - '0' + "";
					int nextVal = 0;
					while(++i < s.length() && ((nextVal = s.charAt(i) - '0') >= 0 && nextVal <= 9)) val += nextVal;
					operandStack.push(Integer.parseInt(val) * -1);
					--i;
				}
				
			} else if(curChar == ')') {
				//여는 괄호까지 계산하라.
				int opCode = -1;
				while((opCode=opcodeStack.pop()) != OPEN) {
					int val1 = operandStack.pop();
					int val2 = operandStack.pop();
					operandStack.push(val1 + val2);
				}
				if(!opcodeStack.isEmpty()&&opcodeStack.peek() == MINUS) {
					opcodeStack.pop();
					opcodeStack.push(PLUS);
					operandStack.push(operandStack.pop()*-1);
				}
			} else if(curChar == '('){
				opcodeStack.push(OPEN);
			} else {
				String val = curChar - '0' + "";
				int nextVal = 0;
				while(++i < s.length() && ((nextVal = s.charAt(i) - '0') >= 0 && nextVal <= 9)) val += nextVal;
				operandStack.push(Integer.parseInt(val));
				--i;
			}
		}
		while(!opcodeStack.empty()) {
			opcodeStack.pop();
			int val1 = operandStack.pop();
			int val2 = operandStack.pop();
			operandStack.push(val1 + val2);
		}
		return operandStack.pop();
	}
	

	public static void main(String[] args) {
		
		System.out.println(calculate("1-11"));
	}
	

}
