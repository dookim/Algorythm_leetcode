import java.util.ArrayList;
import java.util.List;

class MinStack {
	List<Integer> values = new ArrayList<>();
	List<Integer> minValues = new ArrayList<>();
	
    public void push(int x) {
        values.add(x);
        if(minValues.isEmpty() || minValues.get(minValues.size() - 1) > x) {
        	minValues.add(x);
        } else {
        	minValues.add(minValues.get(minValues.size() - 1));
        }
    }

    public void pop() {
    	int removedIndex = values.size() - 1;
        values.remove(removedIndex);
        minValues.remove(removedIndex);
    }

    public int top() {
        return values.get(values.size() - 1);
    }

    public int getMin() {
        return minValues.get(minValues.size() - 1);
    }
}