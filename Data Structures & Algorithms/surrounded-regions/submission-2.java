class Solution {
    int[][] directions = {{1,0},{0,1},{0,-1},{-1,0}};
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        for(int i = 0; i < m; i++){
            if(board[i][0] == 'O'){
                board[i][0] = 'Z';
                dfs(board, i , 0);
            }
            if(board[i][n-1] == 'O'){
                board[i][n-1] = 'Z';
                dfs(board, i, n - 1);
            }
        }

        for(int i = 0; i < n; i++){
            if(board[0][i] == 'O'){
                board[0][i] = 'Z';
                dfs(board, 0, i);
            }
            if(board[m - 1][i] == 'O'){
                board[m - 1][i] = 'Z';
                dfs(board, m - 1, i);
            }
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] != 'Z') board[i][j] = 'X';
                else board[i][j] = 'O';
            }
        }
    }

    private void dfs(char[][] board, int i, int j){
        int x, y;
        for(int[] dir : directions){
            x = dir[0] + i;
            y = dir[1] + j;
            if(x < 0 || x >= board.length) continue;
            if(y < 0 || y >= board[x].length) continue;
            if(board[x][y] != 'O') continue;
            board[x][y] = 'Z';
            dfs(board, x, y);
        }
    }
}
