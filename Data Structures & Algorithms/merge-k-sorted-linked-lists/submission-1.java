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
        ListNode dummy = new ListNode();
		ListNode curr = dummy, minNode, node;
		int minIndex;
	
		do{
			minNode = null;
			minIndex = 0;
			for(int i = 0; i < lists.length; i++){
				node = lists[i];
				if(node == null) continue;
				if(minNode == null || minNode.val > node.val) {
					minNode = node;
					minIndex = i;
				}
			}
			if(minNode != null){
				curr.next = minNode;
                curr = curr.next;
				lists[minIndex] = minNode.next;
			}
		}while(minNode != null);

		return dummy.next;
    }
}
