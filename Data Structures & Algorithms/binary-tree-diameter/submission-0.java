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
    public int diameterOfBinaryTree(TreeNode root) {
        Holder holder = new Holder();
        solve(root, holder);
        return holder.max - 1;
    }

    private int solve(TreeNode root, Holder holder){
        if(root == null) return 0;
        int left = solve(root.left, holder);
        int right = solve(root.right, holder);
        holder.max = Math.max(holder.max, left + right + 1);
        return Math.max(left, right) + 1;
    }
}
class Holder{
    int max = 0;
}
