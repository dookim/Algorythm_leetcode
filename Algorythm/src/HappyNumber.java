import java.util.HashSet;
import java.util.Set;


public class HappyNumber {
	
	public boolean isHappy(int n) {
		Set<Integer> befores = new HashSet<Integer>();
		//19라서 happy number인 경우
		//23순환해서 happy number인 경우
		while(n != 1) {
			int sum = 0;
			int forSum = n;
			while(forSum != 0) {
				sum+=Math.pow(forSum%10, 2);
				forSum /= 10;
			}
			//n은 while문 안에 있으므로.
			n = sum;
			//temp는 자릿수를 검사하기 위한 숫자.
			if(befores.contains(n)) return false;
			//이밑부터는 1이 내려올 가능성은 없다.
			//하나의 자릿수마다 검사한다.
			befores.add(n);
		}
		//와일문을 빠져나왔다는건 1이라는 소리 이므로 
		return true;
	}
	
}
