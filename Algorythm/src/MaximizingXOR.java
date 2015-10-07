import java.util.Scanner;


public class MaximizingXOR {
	static int findMaximum(int a, int b) {
		int result = Integer.MIN_VALUE;
		for(int i = a; i <= b; i++) {
			for(int j = i; j <= b; j++) {
				result = Math.max(result, i^j);
			}
		}
		return result;
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int a = s.nextInt();
		int b = s.nextInt();
		System.out.println(findMaximum(a, b));
		s.close();
	}
}
