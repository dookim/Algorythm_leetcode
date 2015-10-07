import java.util.HashMap;
import java.util.Map;


public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
    	//값과 index
    	Map<Integer,Integer> map = new HashMap<>();
    	int firstIndex = -1;
    	int secondVal = -1;
    	
    	//값이 같은 경우는 안
    	for(int i = 0; i < nums.length; ++i) {
    		if(map.containsKey(nums[i])) {
    			map.put(nums[i], map.get(nums[i]) + 1);
    		} else {
    			map.put(nums[i], 1);
    		}
    	}
    	
    	for(int i = 0; i < nums.length; ++i) {
    		//하나의 값을 사용함
    		map.put(nums[i], map.get(nums[i]) - 1);
    		int minused = target - nums[i];
    		if(map.containsKey(minused) && map.get(minused) >= 1) {
    			firstIndex = i;
    			secondVal = minused;
    			break;
    		}
    		map.put(nums[i], map.get(nums[i]) + 1);
    	}
    	
    	
    	for(int i = 0; i < nums.length; ++i) {
    		if(firstIndex != i && nums[i] == secondVal) {
    			int results[] = new int[2];
    			if(firstIndex > i) {
    				results[0] = i + 1;
    				results[1] = firstIndex + 1;
    			} else {
    				results[0] = firstIndex + 1;
    				results[1] = i + 1;
    			}
    			return results;
    		}
    	}
    	return null;
    }
}
