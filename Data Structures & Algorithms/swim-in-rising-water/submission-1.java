class Solution {
    private static final int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
    public int swimInWater(int[][] grid) {
        int max = -1;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(0,0,grid[0][0]));
        visited[0][0] = true;
        while(!queue.isEmpty()){
            Node node = queue.poll();
            max = Math.max(max, node.cost);
            //System.out.println("node: "+node + " max:"+max);
            if(node.x == grid.length - 1 && node.y == grid[node.x].length - 1) break;

            for(int[] dir : directions){
                int x = node.x + dir[0];
                int y = node.y + dir[1];
                if(x < 0 || x >= grid.length) continue;
                if(y < 0 || y >= grid[x].length) continue;
                if(visited[x][y]) continue;
                visited[x][y] = true;
                queue.offer(new Node(x, y, grid[x][y]));
            }
        }
        return max;
    }
}
class Node implements Comparable<Node>{
    int x, y, cost;

    Node(int x, int y, int cost){
        this.x = x;
        this.y = y;
        this.cost = cost;
    }

    public int compareTo(Node other){
        return this.cost - other.cost;
    }

    public String toString(){
        return "x: "+ x+ " y: "+y+" cost: "+cost;
    }
}
