class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        UnionFind uf = new UnionFind(edges.length + 1);

        for(int[] edge : edges){
            if(!uf.union(edge[0], edge[1])) return edge;
        }
        return new int[0];
    }
}

class UnionFind{
    private int[] ids;
    private int[] size;
    private int numComponents;

    UnionFind(int n){
        this.numComponents = n;
        init();
    }
    private void init(){
        ids = new int[numComponents];
        size = new int[numComponents];
        for(int i = 0; i < numComponents; i++){
            ids[i] = i;
            size[i] = 1;
        }
    }

    private int find(int node){
        int root = node;

        while(ids[root] != root){
            root = ids[root];
        }
        // Path compression
        while(ids[node] != node){
            node = ids[node];
            ids[node] = root;
        }

        return root;
    }

    private boolean union(int a, int b){
        int root1 = find(a);
        int root2 = find(b);

        if(root1 == root2) return false;

        //Union by rank
        if(size[root1] > size[root2]){
            ids[root2] = root1;
            size[root1] += size[root2];
        } else{
            ids[root1] = root2;
            size[root2] += size[root1];
        }
        numComponents--;
        return true;
    }
}
