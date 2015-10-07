
public class ReverseWord {
    public String reverseWords(String s) {
    	s = s.trim();
    	String ret = "";
    	String splited[] = s.split(" "); 
    	for(int i = splited.length - 1; i > -1; --i) {
    		if(!splited[i].equals("")) {
    			if(ret.equals("")) {
    				ret += splited[i];
    			} else {
    				ret += " " + splited[i];
    			}
    		}
    	}
    	return ret;
    }
	
	public static void main(String[] args) {
		
		ReverseWord rw = new ReverseWord();
		System.out.println(rw.reverseWords("the sky is    blue    "));
	}
}
