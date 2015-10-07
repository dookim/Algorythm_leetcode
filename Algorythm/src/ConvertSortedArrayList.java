
public class ConvertSortedArrayList {
	
    public TreeNode sortedArrayToBST(int[] nums, int from, int to) {
    	if(from == to) return null;
    	if(from + 1 == to) {
    		return new TreeNode(nums[from]);
    	}
    	int mid = (from + to)/2;
    	int midVal = nums[mid];
    	TreeNode node = new TreeNode(midVal);
    	node.left = sortedArrayToBST(nums, from, mid);
    	node.right = sortedArrayToBST(nums, mid + 1, to);
    	return node;
    }
	
    public TreeNode sortedArrayToBST(int[] nums) {
    	return sortedArrayToBST(nums, 0, nums.length);
    }

}
