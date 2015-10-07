import java.util.LinkedList;
import java.util.Queue;


public class MyStack {
	

	private static final int queueSize = 2;
	Queue<Integer> queues[];
	
	public MyStack() {
		// TODO Auto-generated constructor stub
		queues = new LinkedList[queueSize];
		for(int i = 0; i < queueSize; ++i) {
			queues[i] = new LinkedList<Integer>();
		}
	}

    // Push element x onto stack.
    public void push(int x) {
    	for(int i = 0; i < queueSize; ++i) {
			if(!queues[i].isEmpty()) {
				queues[i].add(x);
				return;
			}
		}
    	queues[0].add(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
    	for(int i = 0; i < queueSize; ++i) {
			if(!queues[i].isEmpty()) {
				while(queues[i].size() != 1) {
					queues[(i + 1)%queueSize].add(queues[i].poll());
				}
				queues[i].remove();
				return;
			}
		}
    	throw new IllegalStateException("queue is empty");
    }

    // Get the top element.
    public int top() {
    	for(int i = 0; i < queueSize; ++i) {
			if(!queues[i].isEmpty()) {
				while(queues[i].size() != 1) {
					queues[(i + 1)%queueSize].add(queues[i].poll());
				}
				int ret = queues[i].poll();
				queues[(i + 1)%queueSize].add(ret);
				return ret;
			}
		}
    	throw new IllegalStateException("queue is empty");
    }

    // Return whether the stack is empty.
    public boolean empty() {
    	for(int i = 0; i < queueSize; ++i) {
			if(!queues[i].isEmpty()) {
				return false;
			}
		}
    	return true;
    }
    
    public static void main(String[] args) {
		MyStack ms = new MyStack();
		ms.push(1);
		System.out.println(ms.top());
	}
}
