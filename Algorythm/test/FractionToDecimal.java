import java.util.HashMap;
import java.util.Map;


public class FractionToDecimal {
	
	public static void main(String[] args) {
		System.out.println(fractionToDecimal(1, 214748364));
	}
	
    public  static String fractionToDecimal(int numerator, int denominator) {
    	if(numerator == 0) return "0";
    	StringBuilder ret = new StringBuilder();
    	
    	if(numerator < 0 && denominator < 0) {
    		numerator *= -1;
    		denominator *= -1;
    	} else if(numerator < 0 || denominator < 0) {
    		ret.append("-");
    		numerator=Math.abs(numerator);
    		denominator= Math.abs(denominator);
    	}
    	 
    	 int itr = 0;
    	 //b +1번 돌고.
    	 while(numerator > 0 && itr < denominator +1) {
    		 if(itr++ == 1) ret.append(".");
    		 int divided = numerator/denominator;
    		 ret.append(divided);
    		 numerator=numerator%denominator*10;
    	 }

    	 if(numerator > 0) {
        	 Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        	 //순환소수인 경우
        	 StringBuilder repeated = new StringBuilder();
        	 
        	 while(numerator > 0) {
        		 int divided = numerator/denominator;
        		 if(!map.containsKey(divided)) {
        			 map.put(divided, 1);
        		 } else {
        			 int val = map.get(divided);
        			 if(val == 2) {
        				 break;
        			 }
        			 map.put(divided, val + 1);
        		 }
        		 repeated.append(divided);
        		 numerator=numerator%denominator*10;
        	 }
        	 String origin = repeated.substring(0, repeated.length()/2);
        	 //String changed = origin.substring(origin.length() - 1, origin.length())+ origin.substring(0, origin.length() - 1);
        	 String minString = origin;
        	 int min = ret.indexOf(origin);
        	 
        	 /*
        	 while(!repeated.equals(changed)) {
        		 int index = ret.indexOf(changed);
        		 //없는 경우
        		 if(index == -1) continue;
        		 if(index < min) {
        			 min = index;
        			 minString = changed;
        		 }
        		 changed = changed.substring(changed.length() - 1, changed.length())+ changed.substring(0, changed.length() - 1);
        	 }
        	 */
        	 return ret.substring(0, min) + "(" + minString + ")";
    	 }    	 
		return ret.toString();
    }

}
