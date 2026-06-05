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
    public int maxDepth(TreeNode root) {
        // find max of left
        // find max of right
        // return 1 + max(left, right)
        if(root == null) return 0;
        int maxRight = 1 + maxDepth(root.right);
        int maxLeft = 1 + maxDepth(root.left);
        return Math.max(maxRight, maxLeft);
    }
}
