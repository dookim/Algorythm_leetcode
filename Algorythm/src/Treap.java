import java.util.Random;
import java.util.Scanner;

public class Treap {
	static Random randomGenerator = new Random();
	static Integer MAX_INT = 10000;

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int testcase = scanner.nextInt();
		for(int testindex = 0; testindex < testcase; testindex++) {
			Node root = null;
			int length = scanner.nextInt();
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			double value = 1983;
			int index = -1;
			double sum = 0;
			
			for(int i = 0; i < length; i++) {
				//System.out.println(value);
				if(i == 0) root = new Node(value);
				else root = insert(root,new Node(value));
				value = ((value * a) + b) % 20090711;
				index = root.nodeNum % 2 == 0 ? root.nodeNum/2 : root.nodeNum/2 + 1;
				sum += find(root, index);
			}
			System.out.println((int)(sum%20090711));
		}
		scanner.close();

	}
	
	// tree가 잘못만들어졌다.
	// 왜 잘못만들어졌을까?
	public static double find(Node node, int index) {
		// index는 1부터 children까지의 index를 갖고 있다.
		if (index < 1 || node.nodeNum < index) {
			throw new IllegalStateException("indexOutofBoundException index : "
					+ index);
		}
		// node.left가 널일경우를 생각해야한다.
		if (node.left != null && node.left.nodeNum >= index) {
			return find(node.left, index);
		} else if ((node.left != null && node.left.nodeNum + 1 == index)
				|| (node.left == null && index == 1)) {
			return node.value;
		} else {
			return find(node.right, index- (node.nodeNum - node.right.nodeNum));
		}

}



	public static void updateNodeNum(Node node) {
		if (node == null)
			return;
		node.nodeNum = 1;
		if (node.left != null)
			node.nodeNum += node.left.nodeNum;
		if (node.right != null)
			node.nodeNum += node.right.nodeNum;
	}

	public static void cut(Node parent, Node child) {

		if (parent == null || child == null)
			return;
		if (parent.left != null && parent.left.equals(child)) {
			parent.left = null;
		} else if (parent.right != null && parent.right.equals(child)) {
			parent.right = null;
		} else {
			throw new IllegalStateException("parent dont have " + child);
		}

	}

	// 어떻게 보관해야할까?
	// 말단 노드의 갯수는 항상 정상적으로 유지해야한다. 만약 그렇지 않다면 마지막 업데이트시 오류가 난다.
	static Pair split(Node root, Node cur, Node biggerLeaf, Node smallerLeaf,
			Pair pair, double value) {
		// 다순회한경우.
		if (cur == null) return pair;
		if (cur.value >= value) {
			// 왼쪽과 루트를 분리한다.
			Node moved = cur.left;
			cut(cur, cur.left);
			// 말단 노드의 갯수를 항상 최신으로 업데이트 시켜준다.
			updateNodeNum(cur);
			if (pair.biggerRoot == null) pair.biggerRoot = cur;
			// 덧붇이는 부분.
			if (biggerLeaf != null) biggerLeaf.left = cur;
			Pair returned = split(root, moved, cur, smallerLeaf, pair, value);
			// split 함수에서 biggerLeaf에 노드를 추가했으므로!
			updateNodeNum(cur);
			return returned;
		} else {
			// 왼쪽과 루트를 분리한다.
			Node moved = cur.right;
			cut(cur, cur.right);
			updateNodeNum(cur);
			if (pair.smallerRoot == null) pair.smallerRoot = cur;
			if (smallerLeaf != null) smallerLeaf.right = cur;
			Pair returned = split(root, moved, biggerLeaf, cur, pair, value);
			// split 함수에서 SmallerLeaf에 노드를 추가했으므로!
			updateNodeNum(cur);
			return returned;
		}

	}

	public static Node insert(Node cur, Node inserted) {
		if (cur == null) return inserted;

		if (cur.priority >= inserted.priority) {
			if (cur.value <= inserted.value) {
				cur.right = insert(cur.right, inserted);
			} else {
				cur.left = insert(cur.left, inserted);
			}
			updateNodeNum(cur);
			return cur;
		} else {
			// root만 생각할것.
			// 결국 cur이 root다. 루트는 항상 상위에있는게 루트가 아니고 처음불리는 녀석이 루트이므로.
			// 값의 크기와 상관없이 항상 같은 행동을 한다.
			//누구한테 붇이지 ?
			Pair pair = split(cur, cur, null, null, new Pair(), inserted.value);
			inserted.right = pair.biggerRoot;
			inserted.left = pair.smallerRoot;
			updateNodeNum(inserted);
			return inserted;
		}

	}

	static class Node {
		public double value;
		public int priority;
		public Node left;
		public Node right;
		public int nodeNum;

		public Node(double value) {
			// TODO Auto-generated constructor stub
			this.value = value;
			this.priority = randomGenerator.nextInt(MAX_INT);
			this.left = null;
			this.right = null;
			this.nodeNum = 1;
		}
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return " priority : " + priority + " value : " + value;
			
		}
	}

	static class Pair {
		Node biggerRoot;
		Node smallerRoot;

		public Pair() {
			// TODO Auto-generated constructor stub
			this.biggerRoot = null;
			this.smallerRoot = null;
		}
	}

}