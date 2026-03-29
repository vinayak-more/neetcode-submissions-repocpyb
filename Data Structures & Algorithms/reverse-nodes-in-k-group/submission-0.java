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
    public ListNode reverseKGroup(ListNode head, int k) {
        Stack<ListNode> stack = new Stack<>();
        ListNode result = new ListNode();
        ListNode cur = head, node = result;
        while(cur != null){

            for(int i = 0; i < k && cur != null; i++){
                stack.push(cur);
                cur = cur.next;
            }

            if(stack.size() < k) break;

            while(!stack.isEmpty()){
                node.next = stack.pop();
                node = node.next;
            }

            node.next = cur;
        }

        return result.next;
    }
}
