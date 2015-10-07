import java.util.Scanner;


public class UtopianTree {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int testcase = s.nextInt();
		for(int ti = 0; ti < testcase; ti++) {
			int cycle = s.nextInt();
			int result = 1;
			for(int ci = 1; ci <= cycle; ci++) {
				//홀수 인경
				if(ci%2 == 1) {
					result *= 2; 
				} else {
					result += 1; 
				}
			}
			System.out.println(result);
			
		}
		s.close();
	}
}
