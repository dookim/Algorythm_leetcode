
public class CountAndSay {
	
	private String next(String str) {
		
		StringBuilder sb = new StringBuilder();
		char ex = str.charAt(0);
		int count = 1;
		
		for(int i = 1; i < str.length(); ++i) {
			char cur = str.charAt(i);
			if(cur != ex) {
				//저장 및 초기화.
				sb.append(count + "" + ex);
				count = 1;
			} else {
				count++;
			}
			ex = cur;
		}
		sb.append(count + "" + ex);
		return sb.toString();
	}
	
    public String countAndSay(int n) {
    	String ret = "1";
    	if(n == 1) {
    		return ret;
    	}
    	while(n --> 1) {
    		ret = next(ret);
    	}
    	return ret;
    }
    
    public static void main(String[] args) {
    	CountAndSay cas= new CountAndSay();
    	System.out.println(cas.countAndSay(5));
	}


}
