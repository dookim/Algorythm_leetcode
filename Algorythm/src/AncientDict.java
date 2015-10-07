import java.util.Scanner;

public class AncientDict {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int testCases = s.nextInt();
		
		while (testCases > 0) {
			final int input_size = s.nextInt();
			String[] inputs = new String[input_size];
			init();
		
			for (int i = 0; i < input_size; ++i) {
				inputs[i] = s.next();
			}
			
			getDictOrder(inputs);
			
			--testCases;
		}
			
		s.close();
	}
	
	public static void getDictOrder(String[] inputs) {
		
		// create map
		int[][] al = new int[26][26];
		char v1, v2;
		String cur = inputs[0];
		
		for (int i = 1; i < inputs.length; ++i) {
			
			String tmp = inputs[i];
			int minlen = Math.min(cur.length(), tmp.length());
			for (int j = 0; j < minlen; ++j) {
				
				if ((v1 = cur.charAt(j)) != (v2 = tmp.charAt(j))) {
					al[v1-'a'][v2-'a'] = 1;
					break;
				}
			}
			
			cur = tmp;
		}
		
		toplogicalSort(al);
	}

	static int[] visited = new int[26];
	static StringBuilder order = new StringBuilder();
	
	private static void getOrder(int[][] al, int here) {
		visited[here] = 1;
	    for (int there = 0; there < al.length; ++there){
	        if ((al[here][there] == 1) && (visited[there] == 0)) {
	            getOrder(al, there);
	        }
	    }
	    
	    order.append((char)('a' + here));
	}
	
	private static void init() {
		order.setLength(0);
		for(int i = 0; i < visited.length; ++i) {
			visited[i] = 0;
		}
	}
	
	
	private static void toplogicalSort(int[][] al) {
		for (int i = 0; i < 26; ++i) {
			if (visited[i] == 0) getOrder(al, i);
		}
		
		order.reverse();
		
	    for (int i = 0; i < 25; ++i) {
	        for (int j = i + 1; j < 26; ++j) {
	        	// when it is not DAG
		        if (al[order.charAt(j)-'a'][order.charAt(i)-'a'] == 1) {
		        	System.out.println("INVALID HYPOTHESIS");
		        	return ;
		        }
	        }
	    }
	    System.out.println(order.toString());
	    
	}
}