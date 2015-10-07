import java.util.Arrays;


public class hIndex {
	
    public static int hIndex(int[] citations) {
    	if(citations.length == 0) return 0;
     	Arrays.sort(citations);
    	int ex = -1;
    	int cur = -1;
    	for(int i = 0; i < citations.length; ++i) {
    		if(ex == -1 || ex != cur) {
    			cur = citations.length - i;
    		} else {
    			cur = ex;
    		}
    		if(cur == citations[i]) {
    			return cur;
    		}
    	}
    	return 0;
    }
    
    public static void main(String[] args) {
    	int arr[] = {3, 0, 6, 1, 5};
		System.out.println(hIndex(arr));
	}

}
