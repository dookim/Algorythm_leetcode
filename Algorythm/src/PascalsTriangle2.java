import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class PascalsTriangle2 {
	
    public  List<Integer> getRow(int rowIndex) {

    	int[] ex = new int[1 + rowIndex];
    	int[] cur = new int[1 + rowIndex];
    	ex[0] = 1;
    	int size = 1;

    	while(rowIndex --> 0) {
    		cur[0] = 1;
        	for(int i = 1; i < size; ++i) {
        		int added = ex[i - 1] + ex[i];
        		cur[i] = added;
        	}
        	cur[size++] = 1;
        	for(int i = 0; i < size; ++i) {
        		ex[i] = cur[i];
        	}
    	}
    	
    	List<Integer> ret = new ArrayList<>();
    	for(int i = 0; i < size; ++i) {
    		ret.add(ex[i]);
    	}
    	
    	return ret;

    }
    
    public static void main(String[] args) {
		System.out.println(getRow(11));
	}

}
