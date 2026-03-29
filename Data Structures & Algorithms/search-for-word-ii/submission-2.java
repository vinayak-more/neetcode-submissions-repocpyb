class Solution {
    int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = buildTrie(words);
        List<String> result = new LinkedList<>();
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                visited[i][j] = true;
                dfs(board, i, j, visited, root.child[board[i][j] - 'a'], result);
                visited[i][j] = false;
            }
        }
        return result;
    }

    private void dfs(char[][] board, int i, int j, boolean[][] visited, TrieNode root, List<String> result){
        if(root == null) return;
        if(root.isWord){
            root.isWord = false;
            result.add(root.word);
        }
        int x, y;
        for(int[] dir : directions){
            x = dir[0] + i;
            y = dir[1] + j;
            if(x < 0 || x >= board.length) continue;
            if( y < 0 || y >= board[x].length) continue;
            if(visited[x][y]) continue;
            visited[x][y] = true;
            dfs(board, x, y, visited, root.child[board[x][y] - 'a'], result);
            visited[x][y] = false;
        }

    }

    private TrieNode buildTrie(String[] words){
        TrieNode root = new TrieNode();
        for(String word : words){
            TrieNode node = root;
            for(int i = 0; i < word.length(); i++){
                if(node.child[word.charAt(i) - 'a'] == null) 
                    node.child[word.charAt(i) - 'a'] = new TrieNode();
                node = node.child[word.charAt(i) - 'a'];
            }
            node.isWord = true;
            node.word = word;
        }
        return root;
    }
}
class TrieNode{
    boolean isWord = false;
    String word = null;
    TrieNode[] child = new TrieNode[26];
}
