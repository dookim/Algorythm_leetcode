
public class ClimbStairs {
	
	int[] cache = new int[4];
	
    public int climbStairs(int n) {
    	if(n < 3) {
    		return n;
    	}
    	
    	cache[1] = 1;
    	cache[2] = 2;
    	
    	int i = 3;
    	for(;i < n + 1; ++i) {
    		cache[i%4] = cache[(i - 1)%4] + cache[(i - 2)%4];
    	}
    	return cache[(i- 1)%4];
    }
    
    public static void main(String[] args) {
		ClimbStairs stairs = new ClimbStairs();
		System.out.println(stairs.climbStairs(10));
	}
}
