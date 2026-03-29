class Solution {
    public int minCostConnectPoints(int[][] points) {
        List<int[]> edges = buildEdges(points);
        Collections.sort(edges, (a, b) -> a[2] - b[2]);
        UnionFind uf = new UnionFind(points.length);
        int index = 0, cost = 0;
        while(uf.numComponents > 1 && index < edges.size()){
            int[] edge = edges.get(index++);
            if(uf.union(edge[0], edge[1])){
                cost += edge[2];
            }
        }
        return cost;
    }

    private List<int[]> buildEdges(int[][] points){
        int n = points.length;
        List<int[]> edges = new ArrayList<>();
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                int dist = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                edges.add(new int[]{i, j, dist});
            }
        }
        return edges;
    }
}
class UnionFind{
    int numComponents;
    int[] ids;
    int[] size;

    UnionFind(int n){
        this.numComponents = n;
        ids = new int[n];
        size = new int[n];
        for(int i = 0; i < n; i++){
            ids[i] = i;
            size[i] = 1;
        }
    }

    private boolean union(int a, int b){
        int root1 = find(a);
        int root2 = find(b);

        if(root1 == root2) return false;

        if(size[root1] > size[root2]){
            ids[root2] = root1;
            size[root1] += size[root2];
        } else {
            ids[root1] = root2;
            size[root2] += size[root1];
        }
        numComponents--;
        return true;
    }

    private int find(int root){
        while(ids[root] != root){
            root = ids[root];
        }
        return root;
    }
}
