class Solution {
    public boolean validTree(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        for(int[] edge : edges){
            if(!uf.union(edge[0], edge[1])) return false;
        }
        return uf.getNumComponents() == 1;
    }
}
class UnionFind{
    private int[] ids;
    private int[] size;
    private int numComponents;

    public UnionFind(int n){
        this.numComponents = n;
        this.init();
    }

    private void init(){
        int n = this.numComponents;
        ids = new int[n];
        size = new int[n];

        for(int i = 0; i < n; i++){
            ids[i] = i;
            size[i] = 1;
        }
    }

    private int find(int node){
        int root = node;
        while(ids[root] != root){
            root = ids[root];
        }
        //Path compression
        while(ids[node] != node){
            node = ids[node];
            ids[node] = root;
        }
        return root;
    }

    public boolean union(int a, int b){
        int root1 = find(a);
        int root2 = find(b);

        if(root1 == root2) return false;
        //Union by rank
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

    public int getNumComponents(){
        return this.numComponents;
    }

}
