class Solution {
    int[][] directions = {{1,0},{0,1},{-1,0},{0,-1}};
    public int orangesRotting(int[][] grid) {
        int fresh = 0;
        
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                //emtpy cell check
                if(grid[i][j] == 0) continue;

                //fresh orange check
                if(grid[i][j] == 1){
                    fresh++;
                } else{
                    //rotten orange
                    queue.offer(new int[]{i, j});
                }
            }
        }
        //No Fresh Oranges at the start, means either all empty cells or all rotten oranges
        if(fresh == 0) return 0;

        int x, y, levels = 0;
        while(!queue.isEmpty()){
            int levelSize = queue.size();
            for(int i = 0; i < levelSize; i++){
                int[] cell = queue.poll();
                for(int[] dir : directions){
                    x = cell[0] + dir[0];
                    y = cell[1] + dir[1];
                    if(x < 0 || x >= grid.length) continue;
                    if(y < 0 || y >= grid[0].length) continue;
                    if(grid[x][y] != 1) continue;
                    grid[x][y] = 2;
                    fresh--;
                    queue.offer(new int[]{x, y});
                }
            }
            levels++;
        }

        return fresh == 0 ? levels - 1 : -1;
    }
    
}
