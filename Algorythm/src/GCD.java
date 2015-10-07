import java.math.BigInteger;


public class GCD {
	
	public static BigInteger getFactorial(int n) {
		BigInteger ret = BigInteger.ONE;
		for(int i = 1; i <= n; ++i) {
			ret = ret.multiply(BigInteger.valueOf(i));
		}
		return ret;
	}

	
	public static int getGCD(int n, int k) {
		BigInteger nFactorial = getFactorial(n);
		return nFactorial.gcd(BigInteger.valueOf(k)).intValue();
		
	}
	
//	public static void main(String[] args) {
//		System.out.println(getFactorial(300000));
//	}
}
