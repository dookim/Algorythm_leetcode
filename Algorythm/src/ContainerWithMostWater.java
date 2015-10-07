

public class ContainerWithMostWater {

	
	private static String[][] digit = {
		{"I", "V"},
		{"X", "L"},
		{"C", "D"},
		{"M", "D"},
	};
	
	private String getDigitsString(int val ,int d) {
		StringBuilder ret = new StringBuilder();
		if(val <= 3) {
			for(int i = 0; i < val; ++i) {
				ret.append(digit[d][0]);
			}
		} else if(val == 4) {
			ret.append(digit[d][0] + digit[d][1]);
		} else if(val == 5) {
			ret.append(digit[d][1]);
		} else if(val >= 6 && val <= 8) {
			int count = val - 5;
			ret.append(digit[d][1]);
			for(int i = 0; i < count; ++i) {
				ret.append(digit[d][0]);
			}
		} else if(val >= 9) {
			ret.append(digit[d][0] + digit[d+1][0]);
		}
		return ret.toString();
	}
	
    public String intToRoman(int num) {
    	String str = num + "";
    	StringBuilder sb = new StringBuilder();
    	
    	for(int i = 0; i < str.length(); ++i) {
    		int val = str.charAt(i) - '0';
    		sb.append(getDigitsString(val, str.length() - (i + 1)));
    	}
    	
    	return sb.toString();
    }
    
	
	class Node implements Comparable<Node> {
		
		int val;
		int index;
		
		

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return 0;
		}
		
	}
	
	public static void main(String[] args) {
		ContainerWithMostWater w = new ContainerWithMostWater();
		System.out.println(w.intToRoman(1050));;
	}
	


	// bf
	public  int maxArea(int[] height) {

		
		if(height.length <= 1) {
			return 0;
		}
		
		int left = 0;
		int right = height.length - 1;
		int maxArea = 0;
		
		while(right > left) {
			maxArea = Math.max(maxArea, (right - left) * Math.min(height[right], height[left]));
			//왼쪽이 작다면
			if(Math.min(height[right], height[left]) == height[left]) {
				int curLeft = height[left];
				while(right > left && height[++left] <=  curLeft);
			} else {
				int curRight = height[right];
				while(right > left && height[--right] <=  curRight);
			}
		}
		return maxArea;
	}
	

}
