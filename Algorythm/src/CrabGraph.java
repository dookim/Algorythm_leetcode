import java.util.ArrayList;
import java.util.List;


public class CrabGraph {
	
	
	private static int sum = 0;
	private static int feetNum;
	
	//사용되었다면 true반환, 사용되지 않았다면 false 반환
	boolean dfs(int[][] graph, boolean[] used, boolean[] visited, int here, int from) {
		visited[here] = true;
		List<Integer> notUseds = new ArrayList<Integer>();
		
		if(from != -1 && !used[from]) {
			notUseds.add(from);
		}
		
		for(int there = 0; there < graph[here].length; ++there) {
			if(graph[here][there] == 1 && !visited[there]) {
				if(!dfs(graph, used, visited, there, here)) {
					notUseds.add(there);
				}
			}
		}
		
		if(used[here]) {
			return true;
		}
		if(notUseds.size() >= feetNum) {
			int sp = notUseds.size() == feetNum ? 0 : 1;
			sum++;
			used[here] = true;
			for(int i = sp; i < i + feetNum; ++i) {
				used[notUseds.get(i)] = true;
			}
			
			return true;
		}  
		
		return false;
	}
	
	
	
	public static void main(String[] args) {
		
	}
}
