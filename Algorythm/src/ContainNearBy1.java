import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ContainNearBy1 {

	class Node implements Comparable<Node> {
		int index;
		int val;

		public Node(int index, int val) {
			// TODO Auto-generated constructor stub
			this.index = index;
			this.val = val;
		}

		// 오름 차
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return val - o.val;
		}
		
		public void setVal(int val) {
			this.val = val;
		}
		
		public int getVal() {
			return val;
		}
	}

	public static void main(String[] args) {
		ContainNearBy1 cnb = new ContainNearBy1();
		int nums[] = {-1, 10};
		System.out.println(cnb.containsNearbyAlmostDuplicate(nums, 1, 5));

	}

	public boolean containsNearbyDuplicate(int[] nums, int k) {

		List<Node> nodes = new ArrayList<Node>();
		
		for (int i = 0; i < nums.length; ++i) {
			nodes.add(new Node(i, nums[i]));
		}
		Collections.sort(nodes);
		

		for (int i = 0; i < nodes.size(); ++i) {
			Node node = nodes.get(i);
			// 처음이거나 이전값이 앞의 값과 다른경우 값을 할당한다.
			int nextIndex = i;
			// 다음이 같다면.
			Node next = null;
			while (++nextIndex != nodes.size()  && (next = nodes.get(nextIndex)).val == node.val) {
				if (Math.abs(next.index - node.index) <= k) return true;
			}
		}
		return false;
	}
	/*
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

		for(int i = 0; i < nums.length; ++i) {
			for(int j = i + 1; j < i + k; ++j) {
				if(j == nums.length) break;
				if(Math.abs(nums[j] - nums[i]) <= t) return true; 
			}
		}
		return false;
	}
	*/
	
	class IC implements Comparable<IC>{
		
		int val;
		
		public IC(int val) {
			// TODO Auto-generated constructor stub
			this.val = val;
		}
		
		@Override
		public int compareTo(IC o) {
			// TODO Auto-generated method stub
			return val - o.val;
		}
		
		public void setVal(int val) {
			this.val = val;
		}
		
		public int getVal() {
			return val;
		}
		
	}
	//k 는 index 차이
	//t 는 값 차이
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		if(nums.length == 0 || nums.length == 1 || k == 0) return false;
		if(k >= nums.length - 1) {
			Arrays.sort(nums);
			for(int i = 0; i < nums.length - 1; ++i) {
				if(Math.abs(nums[i] - nums[i +1]) <= t) return true;
			}
			return false;
		}
		
		LinkedList<IC> linkedList = new LinkedList<IC>();
		ArrayList<IC> mNums = new ArrayList<IC>();
		
		for(int i = 0; i < nums.length; ++i) {
			mNums.add(new IC(nums[i]));
		}
		
		for(int i = 1; i <= k; ++i) {
			linkedList.add(new IC(nums[i]));
		}
		
		Collections.sort(linkedList);
		if(Math.abs(mNums.get(0).val - linkedList.get(0).val) <= t) return true;
		
		for(int i = 1; i < mNums.size() - 1; ++i) {
			IC cur = mNums.get(i);
			int addedIndex = i + k;
			linkedList.remove(cur);
			if(addedIndex < mNums.size()) {
				linkedList.addFirst(mNums.get(addedIndex));
				//뒤에값이 나보다 클때까지 민다.
				IC temp = null;
				for(int ll = 0; ll < linkedList.size() - 1; ++ll) {
					if(linkedList.get(ll).val <= linkedList.get(ll + 1).val) break;
					//덮어 씌울껄 temp에 넣자.
					temp = linkedList.get(ll + 1);
					linkedList.set(ll + 1, linkedList.get(ll));
					linkedList.set(ll, temp);
				}
			}
			if(Math.abs(cur.val - linkedList.get(0).val) <= t) return true;
		}		
		return false;
	}
}	
