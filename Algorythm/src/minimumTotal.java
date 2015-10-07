import java.util.List;


public class minimumTotal {
    public int minimumTotal(List<List<Integer>> triangle) {
    	if(triangle.size() == 1) {
    		return triangle.get(0).get(0);
    	}
    	
    	for(int r = 1; r < triangle.size(); ++r) {
    		for(int c = 0; c < triangle.get(r).size(); ++c) {
        		if(c == 0) {
        			triangle.get(r).set(c, triangle.get(r - 1).get(c) + triangle.get(r).get(c)); 
        		} else if(c == triangle.get(r).size() - 1) {
        			triangle.get(r).set(c, triangle.get(r - 1).get(c - 1) + triangle.get(r).get(c));
        		} else {
        			int maxVal = Math.min(triangle.get(r - 1).get(c), triangle.get(r - 1).get(c - 1));
        			triangle.get(r).set(c, maxVal + triangle.get(r).get(c));
        		}
        	}
    	}
    	
    	int ret = 987654321;
    	for(int c = 0; c < triangle.get(triangle.size() - 1).size(); ++c) {
    		ret = Math.min(ret, triangle.get(triangle.size() - 1).get(c));
    	}
    	return ret;
    }
}
