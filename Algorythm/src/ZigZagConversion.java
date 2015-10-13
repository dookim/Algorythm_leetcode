
public class ZigZagConversion {
	/*
	 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
	 */
	
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
