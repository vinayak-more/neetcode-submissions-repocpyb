class Solution {
    int[][] directions = {{1,0},{0,1},{-1,0},{0,-1}};
    private static final int LAND = 2147483647;
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == 0){
                    queue.offer(new int[]{i, j});
                }
            }
        }
        bfs(queue, grid);
    }

    private void bfs(Queue<int[]> queue, int[][] grid){
        int level = 1, x, y;
        while(!queue.isEmpty()){
            int levelSize = queue.size();
            for(int i = 0; i < levelSize; i++){
                int[] node = queue.poll();
                for(int[] dir : directions){
                    x = node[0] + dir[0];
                    y = node[1] + dir[1];
                    if(x < 0 || x >= grid.length) continue;
                    if(y < 0 || y >= grid[0].length) continue;
                    if(grid[x][y] != LAND) continue;
                    grid[x][y] = level;
                    queue.offer(new int[]{x, y});
                }
            }
            level++;
        }
    }
}
