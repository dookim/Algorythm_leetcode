import java.math.BigInteger;


public class pow {
	private static BigInteger pow(int a, int d) {
		if(d == 0) {
			return BigInteger.ONE;
		}
		if(d == 1) {
			return BigInteger.valueOf(a*d);
		}
		
		BigInteger temp = pow(a, d/2);
		return d%2 == 0 ? temp .multiply(temp): temp.multiply(temp).multiply(BigInteger.valueOf(a));
	}
	
	public static void main(String[] args) {
		BigInteger result = pow(2,10);
		System.out.println(result);
	}
}
