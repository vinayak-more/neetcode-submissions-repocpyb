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
        Holder holder = new Holder(-1001);
        diameter(root, holder);
        return holder.max - 1;
    }

    public int diameter(TreeNode root, Holder holder){
        if(root == null) return 0;
        int leftDiameter = diameter(root.left, holder);
        int rightDiameter = diameter(root.right, holder);
        holder.max = Math.max(holder.max, leftDiameter + rightDiameter + 1);
        int anotherMax = Math.max(leftDiameter, rightDiameter) + 1;
        holder.max = Math.max(holder.max, anotherMax);
        return anotherMax;
    }
}
class Holder{
    Holder(int max){ this.max = max; }
    int max;
}
