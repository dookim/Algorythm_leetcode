import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;


public class WildCard {
	private static List<String> split(String w) {
		int sp = 0;
		int len = w.length();
		List<String> ret = new ArrayList<String>();
		
		for(int p = 1; p < len; ++p) {
			if(w.charAt(p) == '*') {
				ret.add(w.substring(sp, p));
				sp = p;
			}
		}
		ret.add(w.substring(sp, len));
		return ret;	
	}
	
	private static int checkString(String w, String o, int op, boolean isLast) {
		if(w.charAt(0) == '*' && w.length() == 1) {
			return op;
		}
		if(w.charAt(0) != '*') {
			if(w.length() > o.length()) {
				return -1;
			}
			if(isLast && w.length() != o.length()) {
				return -1;
			}
			for(int i = 0; i < w.length(); ++i) {
				if(w.charAt(i) != o.charAt(op++) && w.charAt(i) != '?') {
					return -1;
				}
			}
			
		} else {
			if(w.length() - 1 > o.length()) {
				return -1;
			}
			if(isLast) {
				op = o.length() - 1;
				for(int i = w.length() - 1; i > 0; --i) {
					if(w.charAt(i) != o.charAt(op--) && w.charAt(i) != '?') {
						return -1;
					}
				}
			} else {
				int wp = 1;
				while(op != o.length() && wp != w.length()) {
					if(w.charAt(wp++) != o.charAt(op++)) {
						wp = 1;
					}
				}
				if(wp != w.length()) {
					op = -1;
				}
			}
		}
		return op;
	}
	
	private static boolean check(String o, List<String> splited) {
		int op = 0;
		for(int i = 0; i < splited.size(); ++i) {
			//맨앞인 경우(문자열에 아예 별이 없는 경우도 있을수 있음)
			if((op=checkString(splited.get(i), o, op, i == splited.size() - 1)) == -1) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int tc = s.nextInt();
		while(tc --> 0) {
			String w = s.next();
			List<String> ws = split(w);
			int fn = s.nextInt();
			PriorityQueue<String> pq = new PriorityQueue<>();
			while(fn-->0) {
				String o = s.next();
				if(check(o, ws)) {
					pq.add(o);
				}
			}
			while(!pq.isEmpty()) {
				System.out.println(pq.poll());
			}
		}
		s.close()
	}
}
