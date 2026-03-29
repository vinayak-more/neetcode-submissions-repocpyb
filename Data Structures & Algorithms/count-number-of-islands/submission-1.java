class Solution {
    int[][] directions = {{1,0},{0,1},{-1, 0},{0, -1}};
    public int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int count = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    dfs(grid, i, j, visited);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j, boolean[][] visited){
        int x, y;
        for(int[] dir : directions){
            x = i + dir[0];
            y = j + dir[1];
            if(x < 0 || x >= grid.length) continue;
            if(y < 0 || y >= grid[x].length) continue;
            if(grid[x][y] != '1') continue;
            if(visited[x][y]) continue;
            visited[x][y] = true;
            dfs(grid, x, y, visited);
        }
    }
}
