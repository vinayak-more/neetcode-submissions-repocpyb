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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i< inorder.length; i++){
            map.put(inorder[i], i);
        }
        Holder holder = new Holder();
        return build(preorder, inorder, 0, inorder.length - 1, map, holder);
    }

    public TreeNode build(int[] preorder, int[] inorder, int start, int end, Map<Integer, Integer> map, Holder holder){
        if(holder.p >= preorder.length) return null;
        if(start > end) return null;
        TreeNode root = new TreeNode(preorder[holder.p++]);
        root.left = build(preorder, inorder, start, map.get(root.val) - 1, map, holder);
        root.right = build(preorder, inorder, map.get(root.val) + 1, end, map, holder);
        return root;

    }
    class Holder{
        int p = 0;
    }
}
