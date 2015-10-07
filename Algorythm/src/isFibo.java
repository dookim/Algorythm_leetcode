import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class isFibo {
	/*
	 * testcase에 대해서 물어볼것
	 * 시간복잡도를 물어보는지?
	 * 공간복잡도에 대해서 물어보는지 ?
	 * 
	 */
	private static Set<Long> fibos = new HashSet<Long>();
	
	private static void preprocess() {
		long before1 = 1;
		long before2 = 0;
		fibos.add(before1);
		fibos.add(before2);
		long cur = -1;
		double bound = Math.pow(10, 10);
		while((cur = before1 + before2) < bound) {
			fibos.add(cur);
			before2 = before1;
			before1 = cur;
		}
	}

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int testcase = s.nextInt();
		preprocess();
		
		for(int testindex = 0; testindex < testcase; testindex++) {
			long cur = s.nextLong();
			if(fibos.contains(cur)) System.out.println("IsFibo");
			else System.out.println("IsNotFibo");
		}
		s.close();
	}
}
