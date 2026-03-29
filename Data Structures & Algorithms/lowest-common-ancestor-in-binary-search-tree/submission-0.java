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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
		if(p.val < q.val) return lca(root, p, q);
		else return lca(root, q, p);
	}
	
	public TreeNode lca(TreeNode root, TreeNode p, TreeNode q){
		if(root.val == p.val || root.val == q.val) return root;
		if(root.val > p.val && root.val < q.val ) return root;
		if(root.val < p.val) return lca(root.right, p, q);
		return lca(root.left, p, q);
		
	}

}
