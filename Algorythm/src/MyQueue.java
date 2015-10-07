import java.util.Stack;

class MyQueue {
	Stack<Integer> st = new Stack<>();
	Stack<Integer> temp = new Stack<>();
    // Push element x to the back of queue.
    public void push(int x) {
    	st.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
    	if(st.isEmpty()) return;
    	while(!st.isEmpty()) {
    		temp.push(st.pop());
    	}
    	temp.pop();
    	while(!temp.isEmpty()) {
    		st.push(temp.pop());
    	}
    	
    }

    // Get the front element.
    public int peek() {
    	while(!st.isEmpty()) {
    		temp.push(st.pop());
    	}
    	int peeked=temp.peek();
    	while(!temp.isEmpty()) {
    		st.push(temp.pop());
    	}
    	return peeked;
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return st.isEmpty();
    }
}