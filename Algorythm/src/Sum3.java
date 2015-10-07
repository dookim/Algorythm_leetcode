import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sum3 {
	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		if (nums.length < 3) {
			return ret;
		}
		Arrays.sort(nums);
		if (nums[0] > 0) {
			return ret;
		}
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; ++i) {
			if (!map.containsKey(nums[i])) {
				map.put(nums[i], 1);
			} else {
				map.put(nums[i], map.get(nums[i]) + 1);
			}
		}
		
		for (int i = 0; i < nums.length; ++i) {
			if(nums[i] > 0) break;
			map.put(nums[i], map.get(nums[i]) - 1);
			if (i == 0 || (i > 0 && nums[i] != nums[i-1])) {
				for (int j = i + 1; j < nums.length; ++j) {
					map.put(nums[j], map.get(nums[j]) - 1);
					int finded = (nums[i] + nums[j]) * -1;
					if ((j == i+1 || nums[j] != nums[j-1]) && map.containsKey(finded) && map.get(finded) > 0) {
						ret.add(Arrays.asList(nums[i], nums[j], finded));
					}
				}
				for (int j = i + 1; j < nums.length; ++j) {
					map.put(nums[j], map.get(nums[j]) + 1);
				}
			}
		}
		return ret;
	}

	public static void main(String[] args) {
		// int arr[] = {-1, 0, 1, 2, -1, -4};
		/*
		int arr[] = { 7, -1, 14, -12, -8, 7, 2, -15, 8, 8, -8, -14, -4, -5, 7,
				9, 11, -4, -15, -6, 1, -14, 4, 3, 10, -5, 2, 1, 6, 11, 2, -2,
				-5, -7, -6, 2, -15, 11, -6, 8, -4, 2, 1, -1, 4, -6, -15, 1, 5,
				-15, 10, 14, 9, -8, -6, 4, -6, 11, 12, -15, 7, -1, -9, 9, -1,
				0, -4, -1, -12, -2, 14, -9, 7, 0, -3, -4, 1, -2, 12, 14, -10,
				0, 5, 14, -1, 14, 3, 8, 10, -8, 8, -5, -2, 6, -11, 12, 13, -7,
				-12, 8, 6, -13, 14, -2, -5, -11, 1, 3, -6 };
		*/
		 int arr[] = {0,0,0};
		List<List<Integer>> ret = threeSum(arr);
		for (int i = 0; i < ret.size(); ++i) {
			System.out.println(ret.get(i));
		}
	}
}
