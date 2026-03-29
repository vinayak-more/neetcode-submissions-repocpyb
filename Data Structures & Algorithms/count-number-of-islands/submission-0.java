class Solution {
    int[][] directions = {{1,0},{0,1},{0,-1},{-1,0}};
    public int numIslands(char[][] grid) {
        int count = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == '0') continue;
                grid[i][j] = '0';
                count++;
                dfs(grid, i, j);
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j){
        int x, y;
        for(int[] dir : directions){
            x = dir[0] + i;
            y = dir[1] + j;
            if(x < 0 || x >= grid.length) continue;
            if(y < 0 || y >= grid[x].length) continue;
            if(grid[x][y] == '0') continue;
            grid[x][y] = '0';
            dfs(grid, x, y);
        }
    }
}
