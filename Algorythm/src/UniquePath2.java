
public class UniquePath2 {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
    	
    	int rLen = obstacleGrid.length;
    	int cLen = obstacleGrid[0].length;
    	int r = 0;
    	int c = 0;
    	if(obstacleGrid[r][c] == 1 || obstacleGrid[rLen- 1][cLen- 1] == 1) {
    		return 0;
    	}
    	
    	obstacleGrid[r][c] = -1;
    	while(r != rLen && c != cLen) {
    		int tr = r - 1;
    		int tc = c + 1;
    		while(++tr < rLen && --tc >= 0) {
    			if(obstacleGrid[tr][tc] < 0) {
	                if( tc + 1 < cLen && obstacleGrid[tr][tc + 1] != 1) {
	                	obstacleGrid[tr][tc + 1] += obstacleGrid[tr][tc];
	                }
	                if(tr + 1 < rLen && obstacleGrid[tr + 1][tc] != 1 ) {
	                	obstacleGrid[tr + 1][tc] += obstacleGrid[tr][tc];
	                }
    			}
    		}
            if(c + 1 < cLen) {
                c++;
            } else {
                r++;
            }
    	}
    	return -obstacleGrid[rLen - 1][cLen - 1];
    	
    }
    
    public static void main(String[] args) {
		int[][] arr = {
				{0,0,0},
				{0,1,0},
				{0,0,0},
		};
		
		System.out.println(uniquePathsWithObstacles(arr));
	}
}
