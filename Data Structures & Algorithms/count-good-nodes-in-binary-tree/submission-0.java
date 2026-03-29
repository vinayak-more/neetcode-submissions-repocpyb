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
    public int goodNodes(TreeNode root){
		if(root == null) return 0;
		Holder holder = new Holder();
		solve(root, root.left, holder);
		solve(root, root.right, holder);
		return holder.count + 1;
	}
	
	private void solve(TreeNode root, TreeNode node, Holder holder){
		if(node == null ) return;
        System.out.println(root.val + " "+node.val);
		if(node.val >= root.val){
			holder.count++;
			root = node;
		}
		solve(root, node.left, holder);
		solve(root, node.right, holder);
	}
}
public class Holder{
	int count = 0;
}

