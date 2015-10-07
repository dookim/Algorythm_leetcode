
public class removeDuplicates {
	
	private static void move(int sp, int size, int[] arr) {
		for(;sp < arr.length; ++sp) {
			arr[sp - size] = arr[sp];
		}
	}
	
	//[-3,-1,-1,0,0,0,0,0,2]
		
	// 1 1 2
    public static int removeDuplicates(int[] nums) {
    	if(nums.length == 0) {
    		return nums.length;
    	}
    	
    	int ex = nums[0];
    	int valNum = 1;
    	
    	int i = 1;
    	int len = nums.length;
    	while(i < len) {
    		int cur = nums[i];
    		if(cur == ex) {
    			valNum++;
    		} else {
    			if(valNum > 1) {
    				move(i, valNum - 1, nums);
    				i -= valNum - 1;
    				len -= valNum - 1;
    			}
    			valNum = 1;
    		}
    		++i;
    		ex = cur;
    		
    	}
    	
    	if(valNum > 1) {
			len -= valNum - 1;
    	}
    	
    	return len;
    }
    
    public static void main(String[] args) {
    	int arr[] = {1,2};
		removeDuplicates(arr);
	}
    
}
