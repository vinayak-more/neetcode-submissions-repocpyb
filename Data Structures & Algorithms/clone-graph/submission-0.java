/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        return clone(node, new HashMap<>());
    }

    private Node clone(Node root, Map<Integer, Node> map){
        if(root == null) return null;
        if(map.containsKey(root.val)) return map.get(root.val);
        Node node = new Node(root.val);
        map.put(root.val, node);

        for(Node ne : root.neighbors){
            node.neighbors.add(clone(ne, map));
        }
        return node;
    }

}
