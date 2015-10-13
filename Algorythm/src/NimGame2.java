
public class NimGame2 {
	public boolean canWin(int n) {
		if(n <= 3) return true;
		return (n - 3)%4 == 1;
	}

}
