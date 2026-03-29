class Solution {
    int[][] directions = {{1,1},{1,-1},{-1,1},{-1,-1}};
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new LinkedList<>();
        char[][] board = buildBoard(n);
        solve(board, 0, result);
        return result;
    }

    private void solve(char[][] board, int row, List<List<String>> result){
        if(row == board.length){
            List<String> list = new ArrayList<>(row);
            for(int i = 0; i < board.length; i++){
                list.add(new String(board[i]));
            }
            result.add(list);
            return;
        }

        for(int i = 0; i < board.length; i++){
            board[row][i] = 'Q';
            if(isValid(board)) solve(board, row + 1, result);
            board[row][i] = '.';
        }
    }

    private boolean isValid(char[][] board){
        // checking all columns
        int count = 0;
        for(int i = 0; i < board.length; i++){
            count = 0;
            for(int j = 0; j < board.length; j++){
                if(board[j][i] == 'Q') count++;
            }
            if(count > 1) return false;
        }
        //check all diagonals
        int x, y;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++)
            if(board[i][j] == 'Q'){
                for(int[] dir : directions){
                    x = i;
                    y = j;
                    count = 0;
                    while(  x >= 0 && x < board.length &&
                            y >= 0 && y < board.length){
                                if(board[x][y] == 'Q') count++;
                                x += dir[0];
                                y += dir[1];
                    }
                    if(count > 1) return false;
                }
            }
        }
        return true;
    }

    private char[][] buildBoard(int n){
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++){
            Arrays.fill(board[i], '.');
        }
        return board;
    }
}
