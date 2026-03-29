/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> queue = new PriorityQueue<>((a, b)-> a.val - b.val);
		queue.addAll(Arrays.asList(lists));
		ListNode dummy = new ListNode();
		ListNode curr = dummy, node;
		while(!queue.isEmpty()){
			node = queue.poll();
			curr.next = node;
			curr = curr.next;
			if(node.next != null) queue.offer(node.next);
		}
		return dummy.next;
    }
}
