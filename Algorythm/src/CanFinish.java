import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class CanFinish {
	
	
	
	void dfs(List<Integer> list, List<Boolean> visited, int[][] prerequisites, int here) {
		visited.set(here, true);
		
		for(int i = 0; i < prerequisites.length; ++i) {
			int from = prerequisites[i][1];
			int to = prerequisites[i][0];
			if(from == here && !visited.get(to)) {
				dfs(list, visited, prerequisites, to);
			}
		}
		
		list.add(here);
	}
	
	List<Integer> topologicalSort(int numCourses, int[][] prerequisites) {
		List<Integer> list = new ArrayList<Integer>();
		List<Boolean> visited = new ArrayList<Boolean>(Collections.nCopies(numCourses, new Boolean(false)));
		
		for(int there = 0; there < numCourses; ++there) {
			if(!visited.get(there)) {
				dfs(list, visited, prerequisites, there);
			}
		}
		Collections.reverse(list);
		return list;
	}
	
	public boolean contain(int from, int to, List<Set<Integer>> prerequisitesSet) {
		return prerequisitesSet.get(from) != null && prerequisitesSet.get(from).contains(to); 
	}
	
	
    public boolean canFinish(int numCourses, int[][] prerequisites) {
    	
        List<Integer> list = topologicalSort(numCourses, prerequisites);
        List<Set<Integer>> prerequisitesSet = new ArrayList<Set<Integer>>(Collections.nCopies(numCourses,null));
        
        
        for(int i = 0; i < prerequisites.length; ++i) {
        	//빈다면.
        	if(prerequisitesSet.get(prerequisites[i][1]) == null) {
        		prerequisitesSet.set(prerequisites[i][1], new HashSet<Integer>());
        	}
        	prerequisitesSet.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        
        for(int i = 0; i < list.size(); ++i) {
        	for(int j = i +1; j < list.size(); ++j) {
        		if(contain(list.get(j), list.get(i), prerequisitesSet)) {
        			return false;
        		}
        	}
        }
        return true;
    }
    public static void main(String[] args) {
		CanFinish cf= new CanFinish();
		int[][] arr = {{1,0},{2,0}};
		System.out.println(cf.canFinish(3, arr));
	}
}
