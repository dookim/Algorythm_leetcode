import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ServiceLane {
	
	private static void setVertex(List<Integer> list, int vertexNum, Scanner s) {
		//set vertex
		for(int i = 0; i < vertexNum; i++) {
			int vertex = s.nextInt();
			list.add(vertex);
		}
	}
	
	private static int getMinWidth(List<Integer> list, int from, int to) {
		int ret = Integer.MAX_VALUE;
		for(int i = from; i <= to; i++) {
			ret = Math.min(ret, list.get(i));
		}
		return ret;
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int vertexNum = s.nextInt();
		int edgeNum = s.nextInt();
		List<Integer> list = new ArrayList<Integer>();
		setVertex(list, vertexNum, s);
		for(int i = 0; i < edgeNum; i++) {
			int from = s.nextInt();
			int to = s.nextInt();
			System.out.println(getMinWidth(list, from, to));
		}
		
		s.close();
	}
}
