
public class LinkedList1 {
	static class Node {
		Node next;
		int val;
	}
	public void removeDuplicated(Node root) {
		
		Node cur = root;
		Node deletedBefore = null;
		Node deleted = cur.next;
		
		while(cur != null) {
			while(deleted != null) {
				if(cur.val == deleted.val) {
					deletedBefore.next = deleted.next;
				} else {
					deletedBefore = deleted;
				}
				deleted = deleted.next;
				
			}
			cur = cur.next;
		}
	}

	public Node getKthBefore(Node head, int k) {
		Node cur = head;
		Node kThBefore = head;
		//k번째 앞으로 간다.
		for(int i = 0; i < k; ++i) {
			//노드의 총갯수가 k개가 안되므로 null을 리턴한다,
			if(cur == null) return null;
			cur = cur.next;
		}
		
		//cur은 반드시 null이 아니다.	
		while(cur.next != null) {
			kThBefore = kThBefore.next;
			cur=cur.next;
		}
		return kThBefore;
	}
	
	
	/*
	public void removeMiddleNode(Node head) {
		if(head == null) return;
		int size = 0;
		Node cur = head;
		while(cur != null) {
			size++;
			cur=cur.next;
		}
		
		int middleNodeIndex = size/2;
		int curIndex = 0;
		cur = head;
		Node beforeMiddle = null;
		while(cur != null) {
			if(curIndex++ == middleNodeIndex) {
				//하나인경
				if(beforeMiddle == null) {
					head = null;
					break;
				} else {
					beforeMiddle.next = cur.next;
					break;
				}
				
			}
			beforeMiddle = cur;
			cur=cur.next;
		}
	}
	*/
	
	public void removeMiddleNode(Node center) {
		if(center == null) return;
		
		Node cur = center;
		Node before = null;
		
		//노드 하나만 들어왔을때는 지울수가 없음.
		//끝노드는 들어오지 않으므로 cur.next와 before가 null이 동시에 될수는 없다. 고로 npe는 발생할 수 없다.
		while(true) {
			//마지막 노드인 경우.
			if(cur.next == null) {
				before.next = null;
				break;
			} 
			//마지막이 아닌경우.
			else {
				cur.val = cur.next.val;
				before = cur;
				cur = cur.next;
			}
		}
	}
	
	void swap(Node smaller, Node bigger) {
		int temp = smaller.val;
		smaller.val = bigger.val;
		bigger.val = temp;
	}
	
	void partition(Node head, int val) {
		if(head == null) return;
		
		Node smallerIndex = head;
		Node smallerIndexBefore = null;
		Node biggerIndex = head;
		Node biggerIndexBefore = null;
		
		//큰값으로 옮긴다. 큰값이후에는 다 해당 값보다 큰것들만 온다.
		while(biggerIndex != null) {
			if(biggerIndex.val >= val) break;
			biggerIndex = biggerIndex.next;
		}
		
		//널인 경우는 큰것이 없다는 의미이므로 리턴한다.
		if(biggerIndex == null) return;
		
		Node center = biggerIndex;
		
		while(true) {
			//smallerIndex != center는 smaller의 마지막이라는 의미이다.
			while(smallerIndex.val >= val && smallerIndex != center) {
				smallerIndexBefore = smallerIndex;
				smallerIndex = smallerIndex.next;
			}
			
			while(biggerIndex.val < val && biggerIndex != null) {
				biggerIndexBefore = biggerIndex;
				biggerIndex = biggerIndex.next;
			}
			//종료 조건.
			if(smallerIndex == center && biggerIndex == null) break;
			
			//다 작거나 커서 swap해야 하는 경우
			if(smallerIndex != center && biggerIndex != null) {
				swap(smallerIndex, biggerIndex);
			} 
			//두개중에 하나가 마지막 index로 갔다는 의미이다. 이런 경우는 뒤로 이어붇인다.
			else {
				//큰것은 끝까지 갔고 작은게 남아있는 경
				if(biggerIndex == null) {
					//움직여야할 노드를 smaller에서 제거한다.
					if(smallerIndexBefore != null) smallerIndexBefore.next = smallerIndex.next;
					//제거한 노드를 옮긴다.
					Node moved = smallerIndex;
					smallerIndex = smallerIndex.next;
					moved.next = null;
					
					//bigger Side에 노드를 붇인다.
					biggerIndexBefore.next = moved;
				} else {
					//움직여야할 노드를 smaller에서 제거한다.
					if(biggerIndexBefore != null) biggerIndexBefore.next = biggerIndex.next;
					//제거한 노드를 옮긴다.
					Node moved = biggerIndex;
					biggerIndex = biggerIndex.next;
					moved.next = null;
					
					//bigger Side에 노드를 붇인다.
					smallerIndexBefore.next = moved;
				}
			}
		}
	}
}
