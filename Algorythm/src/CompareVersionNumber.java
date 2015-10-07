
public class CompareVersionNumber {
    public static int compareVersion(String version1, String version2) {
    	
    	String[] split1 = version1.split("\\.");
    	String[] split2 = version2.split("\\.");
    	
    	int minLen = Math.min(split1.length, split2.length);
    	
    	for(int i = 0; i < minLen; ++i) {
    		int v1 = Integer.parseInt(split1[i]);
    		int v2 = Integer.parseInt(split2[i]);
    		if(v1 != v2) {
    			return v1 > v2 ? 1 : -1;
    		}
    	}
    	
    	if(split1.length > minLen) {
    		for(int i = minLen; i < split1.length; ++i) {
    			if(Integer.parseInt(split1[i]) > 0) {
    				return 1;
    			}
    		}
    	}
    	
    	if(split2.length > minLen) {
    		for(int i = minLen; i < split2.length; ++i) {
    			if(Integer.parseInt(split2[i]) > 0) {
    				return -1;
    			}
    		}
    	}
    	return 0;
    }
    
    public static void main(String[] args) {
		System.out.println(compareVersion("1", "1.1"));
    	
    	//System.out.println("1.1.1".split("\\.").length);
	}
}
