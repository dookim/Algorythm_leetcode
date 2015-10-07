import java.io.ObjectInputStream.GetField;
import java.util.Scanner;


public class LoveLetterMystery {
	
	private static int getChangedValue(String val) {
		int half = val.length()/2;
		int ret = 0;
		for(int i = 0; i < half; i++) {
			char ch = val.charAt(i);
			char ch1 = val.charAt(val.length() -1 - i);
			ret += Math.abs(ch - ch1);
		}
		return ret;
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int testcase = s.nextInt();
		s.nextLine();
		for(int testindex = 0; testindex< testcase; testindex++) {
			String val=s.nextLine();
			System.out.println(getChangedValue(val));
		}
		
		s.close();
	}
}
