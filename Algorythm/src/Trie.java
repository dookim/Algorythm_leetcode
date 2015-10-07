
class TrieNode {
	
	boolean terminal;
	public static final int NODE_RANGE = 26; 
	TrieNode[] children = new TrieNode[NODE_RANGE];
	
	private int charToNumber(char rawChar) {
		return rawChar - 'a';
	}
	
    // Initialize your data structure here.
    public TrieNode() {
    	this.terminal = false;
    }
    
    public void insert(String str, int pointer) {
    	if (pointer == str.length()) {
    		terminal = true;
    		return;
    	}
    	
    	int edgeIndex = charToNumber(str.charAt(pointer));
    	if(children[edgeIndex] == null) {
    		children[edgeIndex] = new TrieNode();
    	}
    	
    	children[edgeIndex].insert(str, pointer+1);
    }
    
    public boolean search(String str, int pointer) {
    	if (pointer == str.length()) {
    		return terminal;
    	}
    	
    	int edgeIndex = charToNumber(str.charAt(pointer));
    	if(children[edgeIndex] == null) return false;
    	return children[edgeIndex].search(str, pointer+1);
    }
    
    public boolean startsWith(String str, int pointer) {
    	if (pointer == str.length()) {
    		return true;
    	}
    	int edgeIndex = charToNumber(str.charAt(pointer));
    	if(children[edgeIndex] == null) return false;
    	return children[edgeIndex].startsWith(str, pointer+1);
    }
    
}

public class Trie {
    private TrieNode root;
    private static final int START_INDEX = 0;
    

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
    	if(word == null) {
    		return;
    	}
        root.insert(word, START_INDEX);
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
    	if(word == null) {
    		return true;
    	}
        return root.search(word, START_INDEX);
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
    	if(prefix == null) {
    		return true;
    	}
    	return root.startsWith(prefix, START_INDEX);
    }
}
