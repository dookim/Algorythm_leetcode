
public class sortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
    	if(nums.length == 0) return null; 
    	TreeNode[] nodes = new TreeNode[nums.length + 1];
    	
    	for(int i = 0; i < nums.length; ++i) {
    		nodes[i + 1] = new TreeNode(nums[i]);
    	}
    	
    	for(int i = 1; i < nodes.length; ++i) {
    		if(i*2 < nodes.length) nodes[i].left = nodes[i*2];
    		if(i*2 +1 < nodes.length) nodes[i].right = nodes[i*2 + 1];
    	}
    	return nodes[1];
    }
}
