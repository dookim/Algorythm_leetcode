
public class MergeSort {
	private static void mergeSort(int a[],int sorted[] ,int from, int to) {
		if(from == to) {
			return;
		}
		int middle = (from + to)/2;
		mergeSort(a, sorted,from, middle);
		mergeSort(a, sorted,middle + 1, to);
		
		//middle과 to를 다 포함한다.
		//두개의 복사본이 존재한다.
		//결국 복사본이 존재해야 한다느 소린가 ?
		int indexLeft = from;
		int indexRight = middle + 1;
		int sortedIndex = from;
		
		while(indexLeft <= middle && indexRight <= to) {
			if(a[indexLeft] < a[indexRight]) {
				sorted[sortedIndex++] = a[indexLeft++];
			} else {
				sorted[sortedIndex++] = a[indexRight++];
			}
		}
		
		while(indexLeft <= middle) {
			sorted[sortedIndex++] = a[indexLeft++];
		}
		
		while(indexRight <= to) {
			sorted[sortedIndex++] = a[indexRight++];
		}
		
		//sorted to a
		for(int i = from; i <= to; i++) {
			a[i] = sorted[i];
		}
		
	}
	
	public static void main(String[] args) {
		
		int[] a = {3,2,1,4,5,7,8,2,3,11,33};
		int[] sorted = new int[a.length];
		
		mergeSort(a, sorted, 0, a.length-1);
		
		for(int i = 0; i < sorted.length; i++) {
			System.out.println(sorted[i]);
		}
		
		
		
	}
}
