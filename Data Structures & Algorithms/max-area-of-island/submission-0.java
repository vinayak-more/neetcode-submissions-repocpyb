class Solution {
    int[][] directions = {{1,0},{0,1},{0,-1},{-1,0}};
    public int maxAreaOfIsland(int[][] grid) {
        Holder holder = new Holder();

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == 0) continue;
                holder.area = 1;
                grid[i][j] = 0;
                dfs(grid, i, j, holder);
                holder.max = Math.max(holder.max, holder.area);
            }
        }
        return holder.max;
    }

    private void dfs(int[][] grid, int i, int j, Holder holder ){
        int x, y;
        for(int[] dir : directions){
            x = dir[0] + i;
            y = dir[1] + j;
            if(x < 0 || x >= grid.length) continue;
            if(y < 0 || y >= grid[i].length) continue;
            if(grid[x][y] == 0) continue;
            holder.area++;
            grid[x][y] = 0;
            dfs(grid, x, y, holder);
        }
    }
}
class Holder{
    int area = 0;
    int max = 0;
}
