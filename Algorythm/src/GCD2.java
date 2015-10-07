import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;


public class GCD2 {
	
	private static final int MAX = 1000000000;
	
	public static int getGCD(int n, int k) {
		
		if(n < 0 || n > MAX || k < 1 || k > MAX) return -1; 
		
		if(n <= 1 || k == 1) {
			return 1;
		}
			
		if(n >= k) {
			return k;
		}
		
		Map<Integer, Integer> fact = getFactorizationPrime(k);
		Iterator<Integer> iter = fact.keySet().iterator();
		int ret = 1;
		while(iter.hasNext()) {
			int curPrime = iter.next();
			long divider = curPrime;
			long added = -1;
			int total = 0;
			while((added = (n/divider)) > 0) {
				total += added;
				divider *= curPrime;
			}
			
			int min = Math.min(fact.get(curPrime),  total);
			ret *= Math.pow(curPrime, min);
		}
		
		return ret;
	}
	public static Map<Integer, Integer> getFactorizationPrime(int n) {
		if(n == 1) {
			throw new IllegalStateException("one has no prime");
		}
		
		Map<Integer, Integer> fact = new HashMap<>();
		//d는 나누는 수
		int d = 2;
		int dlimit = (int) Math.floor(Math.sqrt(n));
		//n은 나눠지는 수
		while(n > 1) {
			int cnt = 0;
			while(n%d == 0) {
				cnt++;
				n/=d;
			}
			if(cnt != 0) {
				fact.put(d, cnt);
			}
			d++;
			if(d > dlimit) break;
		}
		if(n > 1) fact.put(n,  1);
		return fact;
	}
	
//	public static void testAll(int n, int k) {
//		for(int ki = 1; ki < k; ++ki) {
//			for(int ni = 0; ni < n; ++ni) {
//				if(!test(ni, ki)) {
//					System.out.println("n : " + ni + " k : " + ki);
//					break;
//				} else {
//					//System.out.println("succeed! n : " + ni + " k : " + ki);
//				}
//			}
//		}
//	}
//	
//	public static boolean test(int n, int k) {
//		return getGCD(n, k) == GCD.getGCD(n, k);
//	}
	
	
	
	
	
	public static void main(String[] args) {
		System.out.println(getFactorizationPrime(240));
//		Scanner s = new Scanner(System.in);
//		
//		while(s.hasNext()) {
//			int n = s.nextInt();
//			int k = s.nextInt();
//			System.out.println(getGCD(n, k));
//		}
		//s.close();
	}
}
