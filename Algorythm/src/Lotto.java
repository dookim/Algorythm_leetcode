import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;


public class Lotto {
	//46개의 숫자중에서 6개의 숫자를 랜덤하게 뽑는것.
	private static List<Integer> get6RandomNums() {
		List<Integer> list = new ArrayList<Integer>();
		List<Integer> lottoMachine = new LinkedList<Integer>();
		Random random = new Random();
		for(int i = 1; i <= 46; i++) {
			lottoMachine.add(i);
		}
		for(int i = 0; i < 6; i++) {
			int index = random.nextInt(lottoMachine.size());
			list.add(lottoMachine.get(index));
			lottoMachine.remove(index);
		}
		return list;
		
	}
	
	public static void main(String[] args) {
		List<Integer> list = get6RandomNums();
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}
