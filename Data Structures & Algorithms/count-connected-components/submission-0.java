class Solution {
    public int countComponents(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        for(int[] edge : edges){
            uf.union(edge[0], edge[1]);
        }
        return uf.numComponents;
    }
}

class UnionFind {
    int[] id;
    int[] size;
    int numComponents;

    UnionFind(int n){
        numComponents = n;
        id = new int[n];
        size = new int[n];
        for(int i = 0; i < n; i++){
            id[i] = i;
            size[i] = 1;
        }
    }

    private int find(int node){
        int root = node;
        while(id[root] != root){
            root = id[root];
        }
        return root;
    }

    private void union(int a, int b){
        int root1 = find(a);
        int root2 = find(b);
        if(root1 == root2) return;

        if(size[root1] > size[root2]){
            id[root2] = root1;
            size[root1] += size[root2];
        } else {
            id[root1] = root2;
            size[root2] += size[root1];
        }
        numComponents--;
    }
}