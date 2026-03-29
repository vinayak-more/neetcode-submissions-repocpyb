class Solution {
    int[][] directions = {{1,0},{0,1},{-1,0},{0,-1}};
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == 1){
                    max = Math.max(max, bfs(grid, i, j));
                }
            }
        }
        return max;
    }

    private int bfs(int[][] grid, int i, int j){
        int area = 0, x, y;
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(i, j));
        grid[i][j] = 0;
        while(!queue.isEmpty()){
            Pair pair = queue.poll();
            area++;
            for(int[] dir : directions){
                x = pair.x + dir[0];
                y = pair.y + dir[1];
                if(x < 0 || x >= grid.length) continue;
                if(y < 0 || y >= grid[0].length) continue;
                if(grid[x][y] != 1) continue;
                grid[x][y] = 0;
                queue.offer(new Pair(x, y));
            }
        }
        return area;
    }
}
class Pair{
    int x, y;
    Pair(){};
    Pair(int x, int y){this.x = x; this.y = y;}
}