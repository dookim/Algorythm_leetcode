import java.util.Arrays;
import java.util.Scanner;


public class Candies {
	public static int ask(int index, int inputs[], int cache[]) {
		if(cache[index] != -1) return cache[index];
		
		//corner case
		if(index == 0) {
			if(inputs[index] <= inputs[index + 1]) {
				return cache[index] = 1;
			} else {
				return cache[index] = ask(index +1, inputs, cache) + 1;
			}
		} else if(index == inputs.length - 1) {
			if(inputs[index-1] >= inputs[index]) {
				return cache[index] = 1;
			} else {
				return cache[index] = ask(index-1, inputs, cache) + 1;
			}
			
		} else {
			//둘다 나보다 크다면.
			if(inputs[index - 1] < inputs[index] && inputs[index + 1] < inputs[index]) {
				return cache[index]=Math.max(ask(index-1, inputs, cache), ask(index+1, inputs, cache)) + 1;
			} else if(inputs[index - 1] < inputs[index]) {
				return cache[index] = ask(index -1, inputs, cache) + 1;
			} else if(inputs[index + 1] < inputs[index]) {
				return cache[index] = ask(index +1, inputs, cache) + 1;
			} else {
				return cache[index] = 1;
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int size = scanner.nextInt();
		int[] inputs = new int[size];
		int[] cache = new int[size];
		int sum = 0;
		Arrays.fill(cache, -1);
		
		for(int i = 0; i < size; ++i) {
			inputs[i] = scanner.nextInt();
		}
		
		for(int i = 0; i < size; ++i) {
			
			sum +=	ask(i, inputs, cache);
			
		}
		System.out.println(sum);
		scanner.close();
	}
}
