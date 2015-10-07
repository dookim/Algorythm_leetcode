
public class HouseRobber2 {
	private static int[][] cache;
	
	public   int solve(int from, int to, int[] nums) {
		int len = nums.length;
		int max = 0;
		
		if(cache[from][to] != 0) {
			return cache[from][to];
		}
		
		if(len <= 3) {
			for(int i = from; i != to; i=(i+1)%len) {
				max = Math.max(max, nums[i]);
			}
			max = Math.max(max, nums[to]);
			return cache[from][to] = max;
		}
		
		for(int i = from; i != to; i=(i+1)%len) {
			if(from + 1 >= i) {
				max = Math.max(max, nums[i] + solve((i + 2)%len, (from + len - 1)%len ,nums));
			}
			//max = Math.max(max, b)
		}
		max = Math.max(max, nums[to] + solve((to + 2)%len, (to + len - 2)%len, nums, size - 3));
		
		return cache[from][to] = max;
	}
	
    public   int rob(int[] nums) {
    	if(nums.length == 0) return 0;
    	cache = new int[nums.length][nums.length];
    	return solve(0, nums.length - 1, nums, nums.length);
    }
    public static void main(String[] args) {
		int arr[] = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
		System.out.println(arr.length);
		
		
	}
}
