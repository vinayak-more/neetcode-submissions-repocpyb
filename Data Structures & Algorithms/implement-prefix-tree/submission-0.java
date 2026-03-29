class PrefixTree {

    TrieNode root;

	public PrefixTree() {
		root = new TrieNode();
    	}

    	public void insert(String word) {
		TrieNode node = root;
		for(int i = 0; i < word.length(); i++){
			if(node.child[word.charAt(i) - 'a'] == null ) node.child[word.charAt(i) - 'a'] = new TrieNode();
			node = node.child[word.charAt(i) - 'a'];
		}
		node.isWord = true;
    	}

    	public boolean search(String word) {
		TrieNode node = root;
		for(int i = 0; i < word.length(); i++){
			if(node.child[word.charAt(i) - 'a'] == null ) return false;
			node = node.child[word.charAt(i) - 'a'];
		}
		return node.isWord;

    	}

    	public boolean startsWith(String prefix) {
		TrieNode node = root;
		for(int i = 0; i < prefix.length(); i++){
			if(node.child[prefix.charAt(i) - 'a'] == null ) return false;
			node = node.child[prefix.charAt(i) - 'a'];
		}
		return node != null;

    	}
}

class TrieNode{
	boolean isWord;
	TrieNode[] child;
	TrieNode(){
		isWord = false;
		child = new TrieNode[26];
	}
	
	TrieNode(boolean isWord){
		this.isWord = isWord;
		child = new TrieNode[26];
	}
}
