import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class majorityElement {
    public static List<Integer> majorityElement(int[] nums) {
    	List<Integer> ret = new ArrayList<Integer>();
    	if(nums.length == 0) {
    		return ret;
    	}
        int limit = (nums.length/3) + 1;
        Arrays.sort(nums);
        int numCount = 1;
        for(int i = 1; i < nums.length; ++i) {
        	if(nums[i] != nums[i - 1]) {
        		if(numCount >= limit) {
        			ret.add(nums[i - 1]);
        		}
        		numCount = 1;
        	} else {
        		numCount++;
        	}
        }
        if(numCount >= limit) {
			ret.add(nums[nums.length - 1]);
		}
        return ret;
    }
    
    public static void main(String[] args) {
		int arr[] = {1};
		System.out.println(majorityElement(arr));
	}
}
