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

    Set<String> seen = new HashSet<>();

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        Set<String> seen = new HashSet<>();
        String subTreeHash = hash(subRoot, new HashSet<>());
        hash(root, seen);
        //System.out.println(seen);
        return seen.contains(subTreeHash);
    }

    private String hash(TreeNode node, Set<String> seen) {
        if (node == null) return "#";

        String left = hash(node.left, seen);
        String right = hash(node.right, seen);

        String h = node.val + "," + left + "," + right;
        seen.add(h);
        return h;
    }
}

