
public class ValidPalindrome {
	/*
	 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.
	 */
	
	public String makeLowerCaseAndRemoveExtra(String s) {
		StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); ++i) {
        	char ch = s.charAt(i);
        	if((ch >= 'a' &&  'z' >= ch)) {
        		sb.append(ch + "");
        	} else if(ch >= 'A' &&  'Z' >= ch) {
        		sb.append(Character.toLowerCase(ch) + "");
        	} else if(ch >= '0' &&  '9' >= ch) {
        		sb.append(Character.toLowerCase(ch) + "");
        	}
        }
        return sb.toString();
	}
    public boolean isPalindrome(String s) {
        String converted=makeLowerCaseAndRemoveExtra(s);
        int len = converted.length() / 2;
        for(int i = 0; i < len; ++i) {
        	if(converted.charAt(i) != converted.charAt(converted.length() - 1 - i)) {
        		return false;
        	}
        }
        return true;
    }
    
    public static void main(String[] args) {
    	
		// TODO Auto-generated method stub
    	
    	ValidPalindrome validPalindrome = new ValidPalindrome();
    	System.out.println(validPalindrome.makeLowerCaseAndRemoveExtra(".,").length());
    	
    	

	}
}
