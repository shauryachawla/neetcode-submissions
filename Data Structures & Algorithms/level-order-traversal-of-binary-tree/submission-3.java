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
        if(root == null) return List.of();
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> level = new LinkedList<>();
        level.offer(root);
        while(!level.isEmpty()) {
            int levelSize = level.size();
            List<Integer> levelVals = new ArrayList<>();
            for(int i=0;i<levelSize;i++) {
                TreeNode node = level.poll();
                levelVals.add(node.val);
                if(node.left != null) level.offer(node.left);
                if(node.right != null) level.offer(node.right);
            }
            result.add(levelVals);
        }
        return result;
    }
}
