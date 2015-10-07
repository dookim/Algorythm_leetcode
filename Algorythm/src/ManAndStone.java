import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class ManAndStone {
	
	public static void solve(int n, int a, int b) {
		
		Set<Integer> before = new HashSet<Integer>();
		Set<Integer> cur = new HashSet<Integer>();
		
		for(int i = 1; i < n; i++) {
			if(i == 1) {
				cur.add(a);
				cur.add(b);
			} else {
				for (Integer s : before) {
				    int added1 = s + a;
				    int added2 = s + b;
				    if(!cur.contains(added1)) {
				    	cur.add(added1);
				    }
				    if(!cur.contains(added2)) {
				    	cur.add(added2);
				    }
				}
			}
			before.clear();
			before.addAll(cur);
			cur.clear();
		}
		Integer[] beforeList = before.toArray(new Integer[before.size()]);
		Arrays.sort(beforeList);
		System.out.println("size : " + beforeList.length);
		
	}
	/*
	1
	72
	16
	82
	*/
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int testcase = scanner.nextInt();
		for(int testindex = 0; testindex < testcase; testindex++) {
			int n = scanner.nextInt();
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			solve(n, a, b);
			System.out.println();
			
		}
		scanner.close();
	}
}
