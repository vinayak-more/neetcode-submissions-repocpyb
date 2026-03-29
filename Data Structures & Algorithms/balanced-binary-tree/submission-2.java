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
    public boolean isBalanced(TreeNode root) {
        return isBalanced(root, new HashMap<>());
    }

    private boolean isBalanced(TreeNode root, Map<TreeNode, Integer> map){
        if(root == null) return true;
        if(!isBalanced(root.left, map) || !isBalanced(root.right, map)) return false;
        return Math.abs(height(root.left, map) - height(root.right, map)) <= 1;
    }


    private int height(TreeNode root, Map<TreeNode, Integer> map){
        if(root == null) return 0;
        if(map.containsKey(root)) return map.get(root);
        int h = Math.max(height(root.left, map), height(root.right, map)) + 1;
        map.put(root, h);
        return h;
    }
}

