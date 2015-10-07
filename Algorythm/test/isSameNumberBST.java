import java.util.List;
import java.util.Stack;


public class isSameNumberBST {
	
	class Node {
		int val;
		Node left;
		Node right;
	}
	
	void fillListFromBST(Node root ,List<Node> list) {
		
		Node p = root;
		Stack<Node> stack = new Stack<Node>();
		stack.push(p);
		while(!stack.isEmpty()) {
			if(p.left != null) {
				p = p.left;
				stack.push(p);
				continue;
			}
			if(p.right != null) {
				p = p.right;
				stack.push(p);
				continue;
			}		
		}
	}
	
	
	
	public static void main(String[] args) {
		
	}
}
