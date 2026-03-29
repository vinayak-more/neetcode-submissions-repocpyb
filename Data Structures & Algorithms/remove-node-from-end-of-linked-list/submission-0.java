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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode p = head;
		while( --n > 0){
			p = p.next;
		}
		ListNode q = head;
		ListNode prev = dummy;
		while(p.next != null){
			p = p.next;
			prev = q;
			q = q.next;
		}
		prev.next = q.next;
		q.next = null;
		return dummy.next;

    }
}
