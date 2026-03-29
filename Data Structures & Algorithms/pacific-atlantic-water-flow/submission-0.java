class Solution {
    int[][] directions = {{1,0},{0,1},{0,-1},{-1,0}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        Queue<Pair> tl = new LinkedList<>();
        for(int i = 0; i < m; i++){
            tl.add(new Pair(i, 0));
        }
        for(int i = 0; i < n; i++){
            tl.add(new Pair(0, i));
        }
        Queue<Pair> br = new LinkedList<>();
        for(int i = 0; i < m; i++){
            br.add(new Pair(i, n-1));
        }
        for(int i = 0; i < n; i++){
            br.add(new Pair(m-1, i));
        }

        boolean[][] pacific = bfs(heights, tl);
        boolean[][] atlantic = bfs(heights, br);
        List<List<Integer>> result = new LinkedList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(pacific[i][j] && atlantic[i][j])
                    result.add(Arrays.asList(i, j));
            }
        }
        return result;
    }

    private boolean[][] bfs(int[][] heights, Queue<Pair> queue){
        int m = heights.length, n = heights[0].length;
        boolean[][] visited = new boolean[m][n];
        int levelSize, x, y;
        while(!queue.isEmpty()){
            Pair node = queue.poll();
            visited[node.x][node.y] = true;
            for(int[] dir : directions){
                x = dir[0] + node.x;
                y = dir[1] + node.y;
                if(x < 0 || x >= m) continue;
                if(y < 0 || y >= n) continue;
                if(heights[x][y] < heights[node.x][node.y]) continue;
                if(visited[x][y]) continue;
                visited[x][y] = true;
                queue.offer(new Pair(x, y));
            }
        }
        return visited;
    }

}

class Pair{
    int x, y;

    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}