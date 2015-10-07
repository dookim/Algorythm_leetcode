
public class SearchInsert {
    public int searchInsert(int[] nums, int from, int to, int target) {
    	int mid = (from + to) / 2;
    	int midVal = nums[mid];
    	if(midVal == target) {
    		return mid;
    	}
    	if(to == from + 1) {
    		return midVal < target ? to : from;
    	}
    	if(midVal > target) {
    		return searchInsert(nums, from, mid, target);
    	} 
    	return searchInsert(nums, mid, to, target);
    }
	
    public int searchInsert(int[] nums, int target) {
    	return searchInsert(nums, 0, nums.length, target);
    }
}
