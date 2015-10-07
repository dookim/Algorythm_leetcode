
public class RemoveElement {

	
	private static int findFirstIndexBy(int[] nums,int i, int val) {
		for(;i < nums.length; ++i) {
			if(nums[i] == val) {
				return i;
			}
		}
		return i;
	}
	
	private static void moveBy(int arr[], int from, int to,int offset) {
		for(int i = from; i < to; ++i) {
			arr[i - offset] = arr[i];
		}
	}
	
	public static  int removeElement(int[] nums, int val) {
		int from = findFirstIndexBy(nums, 0, val);
		int valNum = 0;
		
		while(from != nums.length) {
			int i = from;
			for(; i < nums.length; ++i) {
				if(nums[i] == val) {
					valNum++;
				} else {
					from = i;
					break;
				}
			}
			int to = findFirstIndexBy(nums, i , val);
			moveBy(nums, i, to, valNum);
			from = to;
		}
        return nums.length - valNum;
        
    }
	
	public static void main(String[] args) {
		//[0,4,4,0,4,4,4,0,2], 4
		int arr[] = {0,4,4,0,4,4,4,0,2};
		int target = 4;
		removeElement(arr, target);
	}

}
