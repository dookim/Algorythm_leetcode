
public class AddBinary {
	/*
Given two binary strings, return their sum (also a binary string).
For example,
a = "11"
b = "1"
Return "100".
	 */
	
    public String addBinary(String a, String b) {
    	String longer = a.length() > b.length() ? a : b;
    	String shorter = longer.equals(b) ? a : b;
    	
    	String appended = "";
    	int diff = longer.length() - shorter.length();
    	
    	for(int i = 0; i < diff; ++i) {
    		appended += "0";
    	}
    	
    	shorter = appended + shorter;
    	int carry = 0;
    	String ret = "";
    	
    	for(int i = shorter.length() - 1; i >= 0; --i) {
    		int val1 = longer.charAt(i) - '0';
    		int val2 = shorter.charAt(i) - '0';
    		int retVal = val1 + val2 + carry;
    		
    		if(retVal >= 2) {
    			carry = 1;
    			retVal -= 2;
    		} else {
    			carry = 0;
    		}
    		ret = retVal + ret; 
    	}
    	if(carry > 0) {
    		ret = carry + ret;
    	}
    	return ret;
    }

}
