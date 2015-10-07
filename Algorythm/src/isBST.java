import java.util.Stack;


public class isBST {
	
	  
	  static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	  
	  public boolean isValidNode(int curVal, Stack<Integer> left, Stack<Integer> right) {
		  if(left.isEmpty() && right.isEmpty()) return true;
		  if(left.isEmpty() && !right.isEmpty()) return right.peek() < curVal;
		  if(right.isEmpty() && !left.isEmpty()) return left.peek() > curVal;
		  return left.peek() > curVal && right.peek() < curVal;
	  }
	  
	  public boolean isValidBST(TreeNode cur, Stack<Integer> left, Stack<Integer> right) {
		  if(cur == null) return true;
		  if(!isValidNode(cur.val, left, right)) return false;
		  
		  left.push(cur.val);
		  if(!isValidBST(cur.left, left, right)) return false;
		  left.pop();
		  
		  right.push(cur.val);
		  if(!isValidBST(cur.right, left, right)) return false;
		  right.pop();
		  
		  return true;
	  }
	 
	
	    public boolean isValidBST(TreeNode root) {
	    	Stack<Integer> left = new Stack<Integer>();
	    	Stack<Integer> right = new Stack<Integer>();
	    	
	        return isValidBST(root, left, right);
	    }
	
}
