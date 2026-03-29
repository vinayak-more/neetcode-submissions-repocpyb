class Solution {
    public boolean isValidSudoku(char[][] board){
		return isAllRowsValid(board) && isAllColumnsValid(board) && isAllSubBoxesValid(board);
	}

	private boolean isAllRowsValid(char[][] board){
		boolean[] flag = new boolean[10];
		int index;
		for(int i = 0; i < 9; i++){
			Arrays.fill(flag, false);
			for(int j = 0; j < 9; j++){
				if(board[i][j] == '.') continue;
				index = board[i][j] - '0';
				if(flag[index]) return false;
				flag[index] = true;
			}
		}
		return true;
	}
	
	private boolean isAllColumnsValid(char[][] board){
		boolean[] flag = new boolean[10];
		int index;
		for(int i = 0; i < 9; i++){
			Arrays.fill(flag, false);
			for(int j = 0; j < 9; j++){
				if(board[j][i] == '.') continue;
				index = board[j][i] - '0';
				if(flag[index]) return false;
				flag[index] = true;
			}
		}
		return true;
	}
	
	private boolean isAllSubBoxesValid(char[][] board){
		for(int i = 0; i < 9; i+= 3){
			for(int j = 0; j < 9; j+= 3){
				if(!isSubBoxValid(board, i, j)) return false;
			}
		}
		return true;
	}

	private boolean isSubBoxValid(char[][] board, int x, int y){
		boolean[] flag = new boolean[10];
		int index;
		for(int i = x; i < x + 3; i++){
			for(int j = y; j < y + 3; j++){
				if(board[i][j] == '.') continue;
				index = board[i][j] - '0';
				if(flag[index]) return false;
				flag[index] = true;
			}
		}
		return true;
	}

}
