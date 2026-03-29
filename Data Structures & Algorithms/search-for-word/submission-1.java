class Solution {
    private static final int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
    	public boolean exist(char[][] board, String word) {
        	boolean[][] visited = new boolean[board.length][board[0].length];
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[i].length; j++){
				if(board[i][j] == word.charAt(0)){
					visited[i][j] = true;
					if(exist(board, i, j, word, 1, visited)) return true;
					visited[i][j] = false;
				}
			}
		}
		return false;
    	}
	
	public boolean exist(char[][] board, int i, int j, String word, int index, boolean[][] visited){
		if(index == word.length()) return true;
		int x, y;
		for(int[] dir: directions){
			x = dir[0] + i;
			y = dir[1] + j;
			if( x < 0 || x >= board.length ) continue;
			if( y < 0 || y >= board[x].length ) continue;
			if(board[x][y] != word.charAt(index)) continue;
			if(visited[x][y]) continue;
			visited[x][y] = true;
			if(exist(board, x, y, word, index + 1, visited)) return true;
			visited[x][y] = false;
		}
		return false;
	}

}
