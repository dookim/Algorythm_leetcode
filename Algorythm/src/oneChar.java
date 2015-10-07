import java.util.Arrays;


public class oneChar {
	
	private static boolean countnOneMore(char[] chars) {
		//변형해도 되나요?
		//변형하지 못한다면 shallow copy 한다.
		Arrays.sort(chars);
		int length = chars.length;
		char ex = ' ';
		char cur = ' ';
		//ab
		for(int i = 0; i < length; i++) {
			cur = chars[i];
			if(i == 0) {
				ex = cur;
				continue;
			}
			if(cur == ex) return false;
			ex = cur;
		}
		return true;
		
	}
	public static void main(String[] args) {
		String var = "a";
		System.out.println(countnOneMore(var.toCharArray()));
	}
}
