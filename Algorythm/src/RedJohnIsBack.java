import java.util.Arrays;
import java.util.Scanner;


public class RedJohnIsBack {
	
	
	private static void preprocess(int max, int result[]) {
		boolean[] primes = new boolean[max + 1];
		Arrays.fill(primes, true);
		if(max <= 1) return;
		int cnt = 0;
		int len = primes.length;
		for(int i = 2; i < len; ++i) {
			if(primes[i]) {
				cnt++;
				if(Math.pow(i, 2) < len) {
					for(int j = i*i; j < len; j += i) {
						primes[j] = false;
					}
				}
			}
			result[i] = cnt;
		}
	}

	private static int calcCombination(int n, int k) {
		
		int ret = 1;
		for(int i = n-k+1; i <= n; ++i) {
			ret *= i;
		}
		
		for(int i = 1; i <= k; ++i) {
			ret /= i;
		}
		return ret;
	}
	
	private static int getBrickCombination(int n) {
		int cnt = 1;
		int quotient = n/4;
		for(int i = 1; i <= quotient; ++i) {
			cnt += calcCombination(n - (4*i) + i, i);
		}
		return cnt;
	}
	
	
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		int[] inputs = new int[t];
		int max = -1;
		
		for(int i = 0; i < t; ++i) {
			inputs[i] = s.nextInt();
			max = Math.max(max, inputs[i]);
		}
		
		int maxVal = getBrickCombination(max);
		int[] result = new int[maxVal +1];
		preprocess(maxVal, result);
		
		for(int i = 0; i < inputs.length; ++i) {
			System.out.println(result[getBrickCombination(inputs[i])]);;
		}
		
		s.close();
	}
}
