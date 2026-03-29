class WordDictionary {

   TrieNode root;

    	public WordDictionary() {
		root = new TrieNode('-');	
    	}	

    	public void addWord(String word) {
		TrieNode node = root;
		for(int i = 0; i < word.length(); i++){
			if(node.child[word.charAt(i) - 'a' ] == null) node.child[word.charAt(i) - 'a'] = new TrieNode(word.charAt(i));
			node = node.child[word.charAt(i) - 'a'];
		}
		node.isWord = true;
    	}

    	public boolean search(String word) {
            return search(word, 0, root);
    	}

	public boolean search(String word, int index, TrieNode root){
		if(root == null) return false;
		if(index == word.length()) return root.isWord;
		if(word.charAt(index) == '.'){
			for(int i = 0; i < root.child.length; i++){
				if(search(word, index + 1, root.child[i])) return true;
			}
			return false;
		}
		return search(word, index + 1, root.child[word.charAt(index) - 'a'] ); 
			
		
	}

	
}

class TrieNode {
	boolean isWord;
    char letter;
	TrieNode[] child;
	TrieNode(){
		this.isWord = false;
		child = new TrieNode[26];
	}
    TrieNode(char ch){
        this();
        this.letter = ch;
    }
}
