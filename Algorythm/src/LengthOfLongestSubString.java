import java.util.HashMap;
import java.util.Map;


public class LengthOfLongestSubString {
	
	private void remove(int from, int to, String s, Map<Character, Integer> map) {
		for(int i = from; i < to; ++i) {
			map.remove(s.charAt(i));
		}
	}
    public int lengthOfLongestSubstring(String s) {
    	
    	int p1 = 0;
    	int p2 = 0;
    	int len = s.length();
    	int max = -1;
    	Map<Character, Integer> map = new HashMap<>();
    	
    	for(int i = 0; i < len; ++i) {
    		if(map.containsKey(s.charAt(i))) {
    			max = i;
    			p2 = i + 1;
    			p1 = map.get(s.charAt(i)) + 1;
    			remove(0, p1, s, map);
    			map.put(s.charAt(i), i);
    			break;
    		} else {
    			map.put(s.charAt(i), i);
    		}
    	}
    	
    	if(max == -1) {
    		return len;
    	}
    	
    	while(len != p2) {
    		if(map.containsKey(s.charAt(p2))) {
    			max=Math.max(max, p2 - p1);
    			int newP1 = map.get(s.charAt(p2)) +1;
    			remove(p1, newP1, s, map);
    			p1 = newP1;
    		}
    		map.put(s.charAt(p2), p2);
    		p2++;
    	}
    	return max > p2 - p1 ? max : p2 - p1;
    }
    
    public static void main(String[] args) {
    	System.out.println(new LengthOfLongestSubString().lengthOfLongestSubstring("abba"));
	}
}
