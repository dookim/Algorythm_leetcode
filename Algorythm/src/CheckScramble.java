
public class CheckScramble {
	boolean isScramble(String s1, String s2) {
		
		int[] arr = new int[26];
		
		if(s1.length() == 1) {
			return s1.charAt(0)==s2.charAt(0);
		}
		
		for(int i = 0; i < s1.length(); ++i) {
			arr[s1.charAt(i) - 'a']++;
			arr[s2.charAt(i) - 'a']--;
		}
		
		for(int i = 0; i < arr.length; ++i) {
			if(arr[i] != 0) {
				return false;
			}
		}
		int len = s1.length();
		for(int i = 1; i < len; ++i) {
			if(isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i, len), s2.substring(i, len))) {
				return true;
			}
			if(isScramble(s1.substring(len - i, len), s2.substring(0, i)) && isScramble(s1.substring(0, len - i), s2.substring(i, len))) {
				return true;
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		System.out.println(isScramble("great", "rgtae"));
	}

}
