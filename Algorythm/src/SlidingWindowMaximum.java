import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class SlidingWindowMaximum {

	public static void main(String[] args) {
		PriorityQueue<Integer> pq = new PriorityQueue<>(
				new Comparator<Integer>() {

					@Override
					public int compare(Integer o1, Integer o2) {
						// TODO Auto-generated method stub
						return o2 - o1;
					}
				});
		pq.add(1);
		pq.add(2);
		System.out.println(pq.peek());
	}

	public void clearAll(HashMap<Integer, Integer> hash) {
		hash.clear();
	}

	public void popAll(PriorityQueue<Integer> pq) {
		while (!pq.isEmpty()) {
			pq.remove();
		}
	}

	public int[] maxSlidingWindow(int[] nums, int k) {
		int[] result = new int[nums.length - k + 1];
		if (nums.length == 0)
			return new int[0];
		int resultIndex = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>(
				new Comparator<Integer>() {

					@Override
					public int compare(Integer o1, Integer o2) {
						// TODO Auto-generated method stub
						return o2 - o1;
					}
				});

		for (int i = 0; i < k; ++i) {
			pq.add(nums[i]);
		}
		result[resultIndex++] = pq.peek();

		int sp = 0;
		int ep = k - 1;
		HashMap<Integer, Integer> removed = new HashMap<>();

		while (ep++ != nums.length - 1) {
			// 지워야할 노드가 현재 pq와 같다면 지워버리자.
			if (pq.peek() == nums[sp]) {
				pq.remove();
			} else {
				if (!removed.containsKey(nums[sp])) {
					removed.put(nums[sp], 1);
				} else {
					removed.put(nums[sp], removed.get(nums[sp]) + 1);
				}
			}

			// 지워버리는 연산!
			while (!pq.isEmpty() && removed.containsKey(pq.peek())
					&& removed.get(pq.peek()) >= 1) {

				removed.put(pq.peek(), removed.get(pq.peek()) - 1);
				pq.remove();

			}
			sp++;
			pq.add(nums[ep]);
			result[resultIndex++] = pq.peek();
		}

		return result;

	}
}
