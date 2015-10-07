import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class LonelyInteger {
	
	private static int setList(List<Integer> list, int stickNum, Scanner s) {
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < stickNum; i++) {
			int val = s.nextInt();
			list.add(val);
			min = Math.min(val, min);
		}
		return min;
	}
	public static void main(String[] args) {
		List<Integer> list = new LinkedList<Integer>();
		Scanner s = new Scanner(System.in);
		int stickNum = s.nextInt();
		int min=setList(list, stickNum, s);
		int index = -1;
		//있다면 자르려고 시도한다.
		while(list.size() > 0) {
			index = -1;
			System.out.println(list.size());
			//자른다. 2보다 컸을때만 자른다.
			int nextMin = Integer.MAX_VALUE;
			while(list.size() > ++index) {
				list.set(index, list.get(index) - min);
				//잘랐다면 현재 index를 유지하기 위해서 --를 한다.
				if(list.get(index) > 0) nextMin = Math.min(nextMin, list.get(index));
				if(list.get(index) <= 0) list.remove(index--);
				
			}
			min = nextMin;
		}
		s.close();
	}
}
