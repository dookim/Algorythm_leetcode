import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int testCases = s.nextInt();
        while (testCases > 0) {
            System.out.println(solve(s.nextInt()));
            
            --testCases;
        }
        
        s.close();
    }
    
    private static String solve(int n) {
        int a = 0, b = 0;
        StringBuilder sb = new StringBuilder();
        
        for (a = (n / 3); a >= 0; --a) {
            if ((( n - (3 * a)) % 5 ) == 0) {
                b = (n - (3 * a)) / 5;
                break;
            }
        }

        if ((a == -1) && (b == 0)) {
            return "-1";
        }
        
        // replace 3 to 555 and 5 to 33333
        for(; a > 0; --a) {
            sb.append("555");
        }
        for(; b > 0; --b) {
            sb.append("33333");
        }
        
        return sb.toString();
    }
}
