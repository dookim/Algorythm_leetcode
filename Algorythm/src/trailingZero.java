
public class trailingZero {
	
    public static int trailingZeroes(int n) {
    	int numOfTwo = 0;
    	int numOfFive = 0;
    	
    	for(int i = 2; i <= n; i = i + 2) {
        	int temp = i;
        	while(temp%2 == 0) {
        		numOfTwo++;
        		temp /=2;
        	}
    	}
    	
    	for(int i = 5; i <= n; i = i + 5) {
        	int temp = i;
        	while(temp%5 == 0) {
        		numOfFive++;
        		temp /= 5;
        	}
    	}        
        return Math.min(numOfFive, numOfTwo);
    }
    
	public static void main(String[] args) {
		System.out.println(trailingZeroes(200000000));
	}
}
