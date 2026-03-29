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
    public boolean isValidBST(TreeNode root){
		Holder holder = new Holder();
		solve(root, holder);
		return holder.valid;
	}

	private Pair solve(TreeNode root, Holder holder){
		if( root == null ) return new Pair(1001, -1001);
		Pair left = solve(root.left, holder);
		Pair right = solve(root.right, holder);
		if(!holder.valid) return null;
		if(root.val > left.max && root.val < right.min ){
			return new Pair(Math.min(root.val,left.min), Math.max(root.val,right.max));
		} else {
			holder.valid = false;
			return null;
		}
	}
}

class Pair{
	final int min;
	final int max;
	Pair(int min, int max){
		this.min = min;
		this.max = max;
	}
}
class Holder {
	boolean valid = true;
}
