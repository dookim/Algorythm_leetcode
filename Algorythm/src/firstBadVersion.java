//boolean isBadVersion(int version);
public class firstBadVersion extends VersionControl {
	public int firstBadVersion(int from, int to) {
		
		if(to < from) {
			return -1;
		}
		
		if(from == to) {
			return isBadVersion(from) ? from : -1;
		}
		
		int mid = (from + to)/2;
		boolean result = isBadVersion(mid);
		
		if(result) {
			int temp = firstBadVersion(from, mid - 1);
			if(temp == -1) {
				return mid;
			} else {
				return temp;
			}
		} else {
			return firstBadVersion(mid+1, to);
		}
	}
    public int firstBadVersion(int n) {
    	return firstBadVersion(1, n);
    }
    
    public static void main(String[] args) {
		
	}
}
