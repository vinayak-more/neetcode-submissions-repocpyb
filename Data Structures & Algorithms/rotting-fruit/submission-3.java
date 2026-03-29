class Solution {
    int[][] directions = {{1,0},{0,1},{0,-1},{-1,0}};
    public int orangesRotting(int[][] grid) {
        int fresh = 0;

        Queue<Pair> queue = new LinkedList<>();
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == 1) fresh++;
                if(grid[i][j] == 2){
                    queue.offer(new Pair(i, j));
                }
            }
        }
        if(fresh == 0) return 0;
        
        int level = 0, levelSize, x, y;
        while(!queue.isEmpty()){
            levelSize = queue.size();
            for(int i = 0; i < levelSize; i++){
                Pair pair = queue.poll();
                for(int[] dir : directions){
                    x = dir[0] + pair.x;
                    y = dir[1] + pair.y;
                    if(x < 0 || x >= grid.length) continue;
                    if(y < 0 || y >= grid[x].length) continue;
                    if(grid[x][y] != 1) continue;
                    grid[x][y] = 2;
                    fresh--;
                    queue.offer(new Pair(x,y));
                }
            }
            level++;
        }

        return fresh == 0 ? level - 1 : -1;
    }
}

class Pair{
    int x, y;
    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}
