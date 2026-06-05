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
    public List<List<Integer>> levelOrder(TreeNode root) {
        var result = new ArrayList<List<Integer>>();
        var q = new LinkedList<TreeNode>();
        q.add(root);
        while(!q.isEmpty()) {
            var level = new ArrayList<Integer>();
            for(int i = q.size(); i>0; i--) {
                var node = q.poll();
                if(node != null) {
                    level.add(node.val);
                    q.add(node.left);
                    q.add(node.right);
                }
            }
            if(level.size() > 0)
                result.add(level);
        }
        return result;
    }
}
