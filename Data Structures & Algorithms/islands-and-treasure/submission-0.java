class Solution {
    int[][] directions = {{1,0},{0,1},{0,-1},{-1,0}};
    public void islandsAndTreasure(int[][] grid) {
        bfs(grid);
    }

    private void bfs(int[][] grid){
        int level = 1;
        Queue<Pair> queue = new LinkedList<>();
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == 0){
                    queue.offer(new Pair(i,j));
                }
            }
        }
        int levelSize, x, y;
        while(!queue.isEmpty()){
            levelSize = queue.size();
            for(int i = 0 ; i < levelSize; i++){
                Pair pair = queue.poll();
                for(int[] dir : directions){
                    x = dir[0] + pair.x;
                    y = dir[1] + pair.y;
                    if(x < 0 || x >= grid.length) continue;
                    if(y < 0 || y >= grid[x].length) continue;
                    if(grid[x][y] != Integer.MAX_VALUE) continue;
                    grid[x][y] = level;
                    queue.offer(new Pair(x, y));
                }
            }
            level++;
        }

    }
}
class Pair{
    int x, y;
    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}
