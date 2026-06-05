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
    public boolean isValidBST(TreeNode root) {
        return helper(root.left, Integer.MIN_VALUE, root.val) && helper(root.right, root.val, Integer.MAX_VALUE);
    }

    boolean helper(TreeNode node, int minVal, int maxVal) {
        /*
        check if node lies between min and max
        */
        if(node == null) return true;
        if(node.val <= minVal || node.val >= maxVal) return false;
        return helper(node.left, minVal, node.val) && helper(node.right, node.val, maxVal);
    }
}
