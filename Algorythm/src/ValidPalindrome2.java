public class ValidPalindrome2 {

	public boolean isAlphabet(char ch) {
		if ((ch >= 'a' && 'z' >= ch)) {
			return true;
		} else if (ch >= 'A' && 'Z' >= ch) {
			return true;
		} else if (ch >= '0' && '9' >= ch) {
			return true;
		}
		return false;
	}

	public boolean isPalindrome(String s) {
    	if(s.length() == 0) {
    		return true;
    	}
    	int p = -1;
    	int q = s.length();
    	int len = s.length();
    	
        while(true) {
            while(p != len - 1 && !isAlphabet(s.charAt(++p)));
        	while(q != 0 && !isAlphabet(s.charAt(--q)));
        	if(p == len - 1 && q == 0) return false;
        	char pCh = s.charAt(p);
        	char qCh = s.charAt(q);
        	//다른 경우.
        	if(!Character.isDigit(pCh)) {
        		pCh = Character.toLowerCase(pCh);
        	}
        	
        	if(!Character.isDigit(qCh)) {
        		qCh = Character.toLowerCase(qCh);
        	}
        	if(pCh != qCh) return false; 
        	if(p == q || p + 1 == q) break; 
        }
        return true;
    }
	
	public static void main(String[] args) {
		ValidPalindrome2 validPalindrome2 = new ValidPalindrome2();
		System.out.println(validPalindrome2.isPalindrome("race a car"));
	}
}
