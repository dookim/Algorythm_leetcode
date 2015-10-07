
public class PalindromeInteger {
    public static boolean isPalindrome(int x) {
    	if(x < 0) {
    		return false;
    	}
    	
    	int temp = x;
    	int digit = 0;
    	
    	while(temp != 0) {
    		temp = temp/10;
    		digit++;
    	}
    	
    	int rVal = x;
    	int lVal = x;
    	int len = digit/2;
    	
    	for(int i = 0; i < len; ++i) {
    		int rp = rVal%10;
    		int lp = (int) (lVal/Math.pow(10, --digit));
    		
    		if(rp != lp) {
    			return false;
    		}
    		
    		rVal /= 10;
    		lVal -= lp*Math.pow(10, digit);
    	}
    	
    	return true;
    }
    
    public static void main(String[] args) {
		System.out.println(isPalindrome(121343434));
	}
}
