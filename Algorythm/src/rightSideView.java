import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;


public class rightSideView {
	
	 public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		 }
    public List<Integer> rightSideView(TreeNode root) {
    	List<Integer> list = new ArrayList<>();
    	TreeNode cur = root;
    	while(cur != null) {
    		list.add(cur.val);
    		cur = cur.right;
    	}
    	return list;
    }
}
