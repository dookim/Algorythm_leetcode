import java.util.Scanner;


public class SolveMeSecond {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int testcase = s.nextInt();
		for(int testindex = 0; testindex < testcase; testindex++) {
			int a = s.nextInt();
			int b = s.nextInt();
			System.out.println(a + b);
		}
		s.close();
	}
}
