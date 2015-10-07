import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Test {
	
	/*
	public static List<String> findRepeatedDnaSequences(String s) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		List<String> list = new ArrayList<String>();
		int to = 10;
		int offset = 10;
		while(to <= s.length()) {
			String subString = s.substring(to - offset, to++);
			//없다면 
			if(!map.containsKey(subString)) {
				map.put(subString, 1);
			} 
			//있다면 하나 증가시켜서 넣을것.
			else {
				int val = map.get(subString);
				map.put(subString, ++val);
			}	
		}
		
		Iterator<Entry<String, Integer>> it = map.entrySet().iterator();
		
	    while (it.hasNext()) {
	        Map.Entry<String,Integer> pair = (Map.Entry)it.next();
	        if(pair.getValue() > 1) {
	        	list.add(pair.getKey());
	        }
	        it.remove(); // avoids a ConcurrentModificationException
	    }
	    
	    return list;
	    
    }
	
	public static void main(String[] args) {
		List<String> result = findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
		for(int i = 0; i < result.size(); ++i) {
			System.out.println(result.get(i));
		}
	}
	*/
	/*
	public  boolean isPalindrome(String s) {
		if(s.length() == 1 || s.length() == 0) return true;
		int sIndex = 0;
		int eIndex = s.length() - 1;
		int middle = s.length() / 2;
		while(true) {
			if(s.charAt(sIndex) == s.charAt(eIndex)) {
				if(sIndex == middle - 1) return true;
				sIndex++;
				eIndex--;
			} else {
				return false;
			}
		}
	}
	*/
	public boolean isPalindrome(String s) {
		int len = s.length();
		for(int i = 0; i < len / 2; ++i) {
			if(s.charAt(i) == s.charAt(len - 1 - i)) {
				return true;
			}
		}
		return false;
	}
	
	/*
	 * You have two numbers represented by a linked list, where each node contains a single
digit. The digits are stored in reverse order, such that the 1’s digit is at the head of
the list. Write a function that adds the two numbers and returns the sum as a linked
list.
	 */
	
	public Node addValue(Node a, Node b) {
		String valForA = "";
		String valForB = "";
		
		while(a != null) {
			valForA = a.val + "";
			a = a.right;
		}
		while(b != null) {
			valForB = b.val + "";
			b = b.right;
		}
		
		int aVal = Integer.parseInt(new StringBuilder(valForA).reverse().toString());
		int bVal = Integer.parseInt(new StringBuilder(valForB).reverse().toString());
		String added = (aVal + bVal) + "";
		Node start = new Node(added.charAt(0) - '0');
		Node curNode = start;
		
		for(int i = 1; i <added.length(); ++i) {
			int curVal = added.charAt(i) - '0';
			curNode.right = new Node(curVal);
			curNode = curNode.right;
			
		}
		
		return start;
		
	}
	
	
	public Node getFirstNode(Node head) {
		Set<Node> set = new HashSet<Node>();
		Node pointer = head;
		while(! set.contains(pointer)) {
			set.add(pointer);
			pointer = pointer.right;
		}
		return pointer;
	}
	
	
	public  String largestNumber(int[] nums) {
		List<String> list = new ArrayList<String>();
		for(int i = 0; i < nums.length; ++i) {
			list.add(nums[i] + "");
		}
		
		Collections.sort(list, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				String a = o1 + o2;
				String b = o2 + o1;
				return a.compareTo(b)* -1;

			}
		});
		StringBuilder sb = new StringBuilder();
		for(String i : list) {
			sb.append(i);
		}
		
		String ret = sb.toString();
		if(ret.charAt(0) == '0') {
			ret = "0";
		}
		
		return ret;
    }
	
	
	
	public  String shortestPalindrome(String s) {
		if(s == null) return null;
		int checkingLength = s.length();
		if(checkingLength == 0 || checkingLength == 1) return s;
		int p = checkingLength;
		while(isPalindrome(s.substring(0, p--)));
		return new StringBuilder(s.substring(p + 1, s.length())).reverse() + s; 
    } 
	
	public static void main(String[] args) {
		Test test = new Test();
		int arr[] = {3134, 313, 3132};
		System.out.println(test.largestNumber(arr));
		
		String a = "989098279685953394"
				+ "56944893859149094902689398937839883538183810810780707982784676057536747174237321720571007032685668066758674466986636554651163276306626562416221603859725909578457125682552954605422520849804812479847044453428339323905384638363699366436503636357535673516346233993298316330843021297028227452732697246523622362231322281216213206020001921763154815181495141713801147114310901048";
		String b = "98909827968595339456944893859149094902689398937839883538183810810780707982784676057536747174237321720571007032685668066758674466986636554651163276306626562416221603859725909578457125682552954605422520849804812479847044453428339323905384638363699366436503636357535673516346233993298316330843021297028227452732697246523622362231322812216213206020001921763154815181495141713801147114310901048";
		System.out.println(a.equals(b));
	}
}

class Node {
	
	public Node(int val) {
		// TODO Auto-generated constructor stub
		this.val = val;
	}
	int val;
	Node right;
}