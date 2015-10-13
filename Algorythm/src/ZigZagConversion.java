
public class ZigZagConversion {
    public String convert(String s, int numRows) {
    	if(numRows == 1) return s;
    	StringBuilder sb = new StringBuilder();
    	int offset = (numRows - 1) * 2;
    	int p = -1;
    	int len = s.length();
    	for(int i = 0; i < numRows; ++i) {
    		p = i;
    		if(i == 0 || i == numRows - 1) {
    			while(p < len) {
    				sb.append(s.charAt(p) + "");
    				p += offset;
    			}
    		} else {
    			int symetry = (numRows - 1 - i) * 2 + i;
    			while(true) {
    				if(p < len) {
    					sb.append(s.charAt(p) + "");
    					p += offset;
    				} else {
    					break;
    				} if(symetry < len) {
    					sb.append(s.charAt(symetry) + "");
    					symetry += offset;
    				} else {
    					break;
    				}
    			}
    		}
    	}
    	return sb.toString();
    }
    //PAHNAPLSIIGYIR
    public static void main(String[] args) {
		ZigZagConversion zigZagConversion = new ZigZagConversion();
		System.out.println(zigZagConversion.convert("ABCD", 3));
	}
}
