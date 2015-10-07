import java.util.Scanner;


public class CommonChild {
	
	private static int getCommonChildLen(String s1, String s2) {
		
		int strLen = s1.length();
		int[] cache = new int[strLen];
		int totalMax = 0;
		
		for(int i = strLen - 1; i > -1; --i) {
			char ch = s1.charAt(i);
			int max = 0;
			for(int j = strLen - 1; j > -1; --j) {
				if(ch == s2.charAt(j)) {
					int origin = cache[j];
					cache[j] = max + 1;
					max = Math.max(max, origin);
				} else {
					max = Math.max(max, cache[j]);
				}
				totalMax = Math.max(cache[j], totalMax);
			}
		}
		return totalMax;
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String s1 = s.next();
		String s2 = s.next();
		System.out.println(getCommonChildLen(s1, s2));
		s.close();
	}
}
