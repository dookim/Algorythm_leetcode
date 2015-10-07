import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;


public class Graph {
	
	static class Node {
		Node left;
		Node right;
		int data;
	}
	
	//전위 탐색 -> 의미가 없진 않다.
	private static void traverse(Node node) {
		if(node == null) return;
		System.out.println(node.data);
		traverse(node.left);
		traverse(node.right);
	}
	
	private static int V = 10;
	
	private static void dfs(ArrayList<LinkedList<Integer>> adj1, int root)  {
		ArrayList<Boolean> visited = new ArrayList<Boolean>(V);
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(root);
		
		label:
		while(!stack.isEmpty()) {
			int here = stack.peek();
			visited.set(here, true);
			
			//방문하지 않았다면 노드로 이동한다.
			for(int i = 0; i < adj1.get(here).size(); i++) {
				int there = adj1.get(here).get(i);
				if(!visited.get(there)) {
					stack.push(there);
					continue label;
				}
			}
			//다방문했다면 stack에서 pop한다.
			//재귀함수에서 나가는 부
			stack.pop();
		}	
	}
	
	
	public static void main(String[] args) {
		ArrayList<LinkedList<Integer>> adj1 = new ArrayList<LinkedList<Integer>>();;
		ArrayList<ArrayList<Integer>> adj2 = new ArrayList<ArrayList<Integer>>();
	}
}
