import java.util.Scanner;


public class Halloweenparty {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int testcase = s.nextInt();
		for(int ti = 0; ti < testcase; ti++) {
			long val = s.nextLong();
			long mulplied = val/2;
			System.out.println((val-mulplied)*mulplied);
		}
		s.close();
	}
}
