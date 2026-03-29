/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) return Collections.emptyList();
		List<Integer> result = new LinkedList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		int levelSize;
		TreeNode node;
		while(!queue.isEmpty()){
			levelSize = queue.size();
			result.add(queue.peek().val);
			for(int i = 0; i < levelSize; i++){
				node = queue.poll();
				if(node.right != null ) queue.offer(node.right);
				if(node.left != null) queue.offer(node.left);
			}
		}
		return result;
    }
}
