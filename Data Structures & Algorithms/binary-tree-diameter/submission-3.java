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
    int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        var left = height(root.left);
        var right = height(root.right);

        diameter = Math.max(diameter, left + right);
        diameterOfBinaryTree(root.left);
        diameterOfBinaryTree(root.right);
        return diameter;
    }

    public int height(TreeNode root) {
        if(root == null) return 0;
        var left = height(root.left);
        var right = height(root.right);
        return 1 + Math.max(left, right);
    }
}
