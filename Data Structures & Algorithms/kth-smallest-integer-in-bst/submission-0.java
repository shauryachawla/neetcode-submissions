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
        Inorder for BST gives sorted elements. 
        */
        ArrayList<Integer> sorted = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        TreeNode curr = root;
        int counter = k;
        while(counter > 0 && (!s.isEmpty() || curr != null)) {
            while(curr != null) {
                s.push(curr);
                curr = curr.left;
            }
            curr = s.pop();
            sorted.add(curr.val);
            counter--;
            curr = curr.right;
        }
        System.out.println(sorted);
        return sorted.get(k-1);
    }
}
