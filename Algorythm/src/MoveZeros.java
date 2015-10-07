

public class MoveZeros {
	
	private int move(int[] arr, int from, int size) {
		
		while(from < arr.length && arr[from] != 0) {
			arr[from - size] = arr[from++];
		}
		
		int ret = from;
		
		while(size --> 0) {
			arr[--from] = 0;
		}
		
		return ret;
	}
	
	private int findZero(int[] nums, int here) {
		for(; here < nums.length; ++here) {
			if(0 == nums[here]) {
				return here;
			}
		}
		return here;
	}
	
	//  [0, 1, 0, 3, 12]
	
	public void moveZeroes(int[] nums) {
		
		int zeroIndex = findZero(nums, 0);
		int zeroNum = 0;
		
		while(zeroIndex != nums.length) {
			//count zero
			
			for(;zeroIndex < nums.length; ++zeroIndex) {
				if(nums[zeroIndex] == 0) {
					zeroNum++;
				} else {
					break;
				}
			}
			zeroIndex=move(nums, zeroIndex, zeroNum);
		}

	}
}
