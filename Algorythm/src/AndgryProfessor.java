import java.util.Scanner;


public class AndgryProfessor {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int testcase = s.nextInt();
		for(int ti = 0; ti < testcase; ti++) {
			int studentNum = s.nextInt();
			int minVal = s.nextInt();
			int count = 0;
			for(int si = 0; si < studentNum; si++) {
				int time = s.nextInt();
				if(time <= 0) count++;
			}
			if(minVal <= count) System.out.println("NO");
			else System.out.println("YES");
		}
		
		s.close();
	}
}
