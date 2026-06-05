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
    public List<Integer> rightSideView(TreeNode root) {
        var res = new ArrayList<Integer>();
        var q = new LinkedList<TreeNode>();
        q.offer(root);
        while(!q.isEmpty()) {
            TreeNode rightSide = null;
            var qLen = q.size();
            for(int i=0; i<qLen;i++) {
                TreeNode node = q.poll();
                if(node != null) {
                    rightSide = node;
                    q.add(node.left);
                    q.add(node.right);    
                }
            }
            if(rightSide != null)
                res.add(rightSide.val);
        }
        return res;
    }
}
