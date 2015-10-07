
public class Rook {
	
	
	public String  isCorrect(String[] board) {
		int[] arr = new int[board[0].length()];
		for(int i = 0; i < board.length; i++) {
			String val = board[i];
			for(int j = 0; j < val.length(); j++) {
				char ch = val.charAt(j);
				if(ch == 'R') {
					arr[j]++;
				}
			}
		}
		for(int i = 0; i < arr.length; i++) {
			int val = arr[i];
			if(val != 1) return "Incorrect";
		}
		//여기까지 오면 다 1이라는 소리이므로.
		return "Correct";
	}
	
	
	public static void main(String[] args) {
		int[] arr = new int[8];
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}
