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
    public int goodNodes(TreeNode root) {
        return goodNodes(root, new TreeNode(-101));
    }

    public int goodNodes(TreeNode node, TreeNode root){
        if(node == null) return 0;
        if(node.val >= root.val){
            return goodNodes(node.left, node) + goodNodes(node.right, node) + 1;
        } else {
            return goodNodes(node.left, root) + goodNodes(node.right, root);
        }
    }
}
