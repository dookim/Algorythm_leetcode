
public class NimGame {
	/*
	 * You are playing the following Nim Game with your friend: There is a heap of stones on the table, each time one of you take turns to remove 1 to 3 stones. The one who removes the last stone will be the winner. You will take the first turn to remove the stones.

Both of you are very clever and have optimal strategies for the game. Write a function to determine whether you can win the game given the number of stones in the heap.

For example, if there are 4 stones in the heap, then you will never win the game: no matter 1, 2, or 3 stones you remove, the last stone will always be removed by your friend.
	 */
	private static final int me = 1;
	
	private int nextTurn(int n) {
		return (n + 1)%2;
	}
	
	int cache[][];
	//현재 턴에서 남을돌(n)로 내가 이길 수 있는지 확인하는 메서드.
	public int canWin(int n, int turn) {
		if(n <= 3) {
			return cache[n][turn] = turn;
		}
		if(cache[n][turn] != 0) {
			return cache[n][turn];
		}
		for(int i = 1; i <= 3; ++i) {
			if(canWin(n - i, nextTurn(turn)) == turn) {
				return cache[n][turn] = turn;
			}
		}
		
		return cache[n][turn] = nextTurn(turn);
	}
	
	
	
    public boolean canWinNim(int n) {
        cache = new int[n + 1][2];
        return canWin(n, me) == me;
    }
    
    
    public static void main(String[] args) {
		NimGame nimGame = new NimGame();
		System.out.println(nimGame.canWinNim(7));
	}
    

}
