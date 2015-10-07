import java.util.Scanner;


public class Mountain {
	
	static class Node {
		int min;
		int max;
		
		public Node(int value) {
			// TODO Auto-generated constructor stub
			this.min = value;
			this.max = value;
		}
		
		public Node(int min, int max) {
			// TODO Auto-generated constructor stub
			this.min = min;
			this.max = max;
		}
		
	}
	
	private static Node makePartialTree(int arr[],Node[] nodes, int from, int to, int index) {
		if(from == to) {
			return nodes[index] = new Node(arr[from]);
		} else {
			int middle = (from + to)/2;
			Node left = makePartialTree(arr, nodes, from, middle, index*2);
			Node right = makePartialTree(arr, nodes, middle + 1, to, index*2 + 2);
			int min = left.min < right.min ? left.min : right.min;
			int max = left.max > right.max ? left.max : right.max;
			return nodes[index] = new Node(min, max);
		}
		
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int testcase = scanner.nextInt();
		for(int testIndex = 0; testIndex < testcase; testIndex++) {
			int signsNum = scanner.nextInt();
			int queryNum = scanner.nextInt();
			int arraySize = 1;
			while(arraySize <= signsNum) {
				arraySize *= 2;
			}
			Node[] nodes = new Node[arraySize*2];
			
			
			
			
		}
		
		
		scanner.close();
	}
}
