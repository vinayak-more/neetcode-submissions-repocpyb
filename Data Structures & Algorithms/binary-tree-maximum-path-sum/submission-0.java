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
    public int maxPathSum(TreeNode root){
		Holder holder = new Holder();
		int max = solve(root, holder);
		return holder.max;
	}
	
	private int solve(TreeNode root, Holder holder){
		if(root == null) return Short.MIN_VALUE;
		int left = solve(root.left, holder);
		int right = solve(root.right, holder);
		int rootMax = Math.max(left + root.val, right + root.val);
		rootMax = Math.max(rootMax, root.val);
		holder.max = Math.max(holder.max, Math.max(rootMax, (left + right + root.val)));
        //System.out.println(rootMax + " For root : " + root.val + " max :"+holder.max);
		return rootMax;
	}

}
class Holder{
	int max = Integer.MIN_VALUE;
}
