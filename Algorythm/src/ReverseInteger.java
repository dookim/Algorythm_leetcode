
public class ReverseInteger {
	
    public static int reverse(int x) {
    	
    	int temp = x;
    	int digits = 0;
    	boolean isMinus = false;
    	
    	if(x < 0) {
    		isMinus = true;
    		x *= -1;
    	}
    	
    	//find digits
    	//343
    	while(temp != 0) {
    		digits++;
    		temp /= 10;
    	}
    	
    	int ret = 0;
    	//digit - > 3
    	while(x != 0) {
    		int cur = x%10;
    		ret += cur * Math.pow(10, --digits);
    		x /= 10;
    	}
    	
    	if(ret == Integer.MAX_VALUE || ret == Integer.MIN_VALUE) {
    		return 0; 
    	}
    	
    	if(isMinus) {
    		ret *= -1;
    	}
    	return ret;
    }	
    
    public static void main(String[] args) {
		System.out.println(Integer.MAX_VALUE);
	}

}
