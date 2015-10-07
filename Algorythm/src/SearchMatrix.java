
public class SearchMatrix {
	
	private boolean solve(int[][] matrix, int r, int c, int target) {
		if(r < 0 || c == matrix[0].length) {
			return false;
		}
		if(target== matrix[r][c]) {
			return true;
		} 
		if(matrix[r][c] < target) {
			return solve(matrix, r, c+1, target);
		}
		return solve(matrix, r-1, c, target);	
	}
    public boolean searchMatrix(int[][] matrix, int target) {
    	int r = -1;
    	for(r = 0; r < matrix.length; ++r) {
    		if(matrix[r][0] > target) {
    			break;
    		}
    	}
    	
    	if(r == matrix.length) r--;
    	
        return solve(matrix, r, 0, target);
    }
    
    public static void main(String[] args) {
    	SearchMatrix sm = new SearchMatrix();
		int[][] arr= {
				  {1,   4,  7, 11, 15},
				  {2,   5,  8, 12, 19},
				  {3,   6,  9, 16, 22},
				  {10, 13, 14, 17, 24},
				  {18, 21, 23, 26, 30}
				
		};
		System.out.println(sm.searchMatrix(arr, 20));
	}
}
