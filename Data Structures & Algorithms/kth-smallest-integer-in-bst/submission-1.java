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
    public int kthSmallest(TreeNode root, int k) {
        Holder holder = new Holder();
        holder.k = k;
        inOrder(root, holder);
        return holder.value;
    }

    private void inOrder(TreeNode root, Holder holder){
        if(root == null) return;
        if( holder.k == 0) return;
        inOrder(root.left, holder);
        holder.k--;
        if(holder.k == 0) holder.value = root.val;
        inOrder(root.right, holder);
    }
}
class Holder{
    int value;
    int k;
}
