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
    int result = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        /*
        if null return 0;
        find left sum
        find right sum
        add val + left + right sum.
        update result;
        */
        treeSum(root);
        return result;
    }

    public int treeSum(TreeNode root) {
        if(root == null) return 0;
        int leftSum = treeSum(root.left);
        int rightSum = treeSum(root.right);
        leftSum = leftSum < 0 ? 0 : leftSum;
        rightSum = rightSum < 0 ? 0 : rightSum;
        result = Math.max(result, leftSum + rightSum + root.val); 
        return Math.max(leftSum, rightSum) + root.val;
    }
}
