/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head){
		Node dummy = new Node(0);
		Node cur = dummy;
		Map<Node, Node> map = new HashMap<>();
		Node temp = head;
		while(temp != null ){
			cur.next = new Node(temp.val);
			cur = cur.next;
			map.put(temp, cur);
			temp = temp.next;
		}
		temp = head;
		cur = dummy.next;
		while(temp != null){
			cur.random = map.get(temp.random);
			cur = cur.next;
			temp = temp.next;
		}
		return dummy.next;
	}

}
