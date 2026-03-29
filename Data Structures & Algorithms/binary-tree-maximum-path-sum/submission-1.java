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
    public int maxPathSum(TreeNode root) {
        Holder holder = new Holder();
        dfs(root, holder);
        return holder.max;
    }

    private int dfs(TreeNode root, Holder holder){
        if(root == null) return -10000;
        int left = dfs(root.left, holder);
        int right = dfs(root.right, holder);
        int currMax = Math.max(Math.max(left, right) + root.val, root.val);
        holder.max = Math.max(holder.max, left + right + root.val);
        holder.max = Math.max(holder.max, currMax);
        holder.max = Math.max(holder.max, root.val);
        return currMax;
    }
}
class Holder{
    int max = Integer.MIN_VALUE;
}