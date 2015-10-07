
public class longestCommonPrefix {
	

	
	private static boolean isAllSame(String[] strs, int index){
		char ch = strs[0].charAt(index); 
		for(int i = 1; i < strs.length; ++i){
			if(ch != strs[i].charAt(index)) {
				return false;
			}
		}
		return true;
	} 
	
    public static String longestCommonPrefix(String[] strs) {
    	
    	if(strs.length == 0) {
    		return "";
    	}
    	
    	if(strs.length == 1) {
    		return strs[0];
    	}
		
    	int min = Integer.MAX_VALUE;
    	int minIndex = -1;
    	
		for(int i = 0; i < strs.length; ++i) {
			if(strs[i].length() < min) {
				min = strs[i].length();
				minIndex = i;
			}
		}
        
        
        for(int i = 0; i < min; ++i) {
        	if(!isAllSame(strs, i)) {
        		return strs[0].substring(0, i);
        	}
        }
        
        return strs[minIndex];
        
    }
    
    public static void main(String[] args) {
		String[] input = {"abb", "abc"};
		System.out.println(longestCommonPrefix(input));
		
	}
}
