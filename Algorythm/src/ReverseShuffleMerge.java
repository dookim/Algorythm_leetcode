import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class ReverseShuffleMerge {
	
	private static String solve(String str) {
		char[] chars = str.toCharArray();
		List<Character> list = new LinkedList<>();
		for(int i = 0; i < chars.length; ++i) {
			list.add(new Character(chars[i]));
		}
		
		

		
		
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String str = s.next();
        System.out.println(solve(str));
		s.close();
	}
}
