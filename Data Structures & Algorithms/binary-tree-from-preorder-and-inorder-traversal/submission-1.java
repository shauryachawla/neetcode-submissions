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
        List<Integer> pre = Arrays.stream(preorder).boxed().collect(Collectors.toList());
        List<Integer> in = Arrays.stream(inorder).boxed().collect(Collectors.toList());
        return buildTree(pre, in);
    }

    TreeNode buildTree(List<Integer> pre, List<Integer> in) {
        if(pre.isEmpty()) return null;
        TreeNode root = new TreeNode(pre.get(0));
        int leftNodes = in.indexOf(pre.get(0));
        root.left = buildTree(pre.subList(1, leftNodes + 1), in.subList(0, leftNodes));
        root.right = buildTree(pre.subList(1+leftNodes, pre.size()), in.subList(leftNodes+1, in.size()));
        return root;
    }
}
