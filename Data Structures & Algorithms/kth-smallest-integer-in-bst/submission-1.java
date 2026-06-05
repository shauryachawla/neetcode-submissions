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
        /*
        inorder will be in ascending.
        stop at k.
        */
        Stack<TreeNode> s = new Stack<>();
        TreeNode curr = root;
        int result = Integer.MAX_VALUE;
        while((!s.isEmpty() || curr != null) && k > 0) {
            while(curr != null) {
                s.push(curr);
                curr = curr.left;
            }
            curr = s.pop();
            System.out.println(curr);
            k--;
            result = curr.val;
            curr = curr.right;
        }
        return result;
    }
}
