
public class CountDigital {
    public int countDigitOne(int n) {
    	if(n < 0) return 0;
    	String stred = n +"";
    	int len = stred.length();
    	int cypher = len - 1;
    	int ret = 0;
    	
    	while(cypher >= 0) {
    		int val = (int)Math.pow(10, cypher);
    		if(cypher ==  len - 1) {
    			if(n - val + 1 >= val) {
    				ret += val;
    			} else {
    				ret += n - val + 1;
    			}
    		} else {
    			int suffix = n / (int) Math.pow(10, cypher+1);
    			ret += suffix * val;
    			int bound = (suffix * (int) Math.pow(10, cypher+1)) + val;
    			if(n - bound + 1 > 0 && n - bound + 1 < val) {
    				ret += n - bound + 1;
    			}
    			else if(n - bound + 1 >= val){
    				ret += val;
    			}
    		}
    		cypher--;
    	}
    	return ret;
    }
    
    public static void main(String[] args) {
		CountDigital cd = new CountDigital();
		System.out.println(cd.countDigitOne(10));
	}
}
