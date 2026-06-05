class Solution {
    public boolean isEmpty(int[] arr) {
        return (arr == null || arr.length == 0);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(isEmpty(preorder)) return null;
        TreeNode root = new TreeNode(preorder[0]);
        // int mid = List.of(inorder).indexOf(root.val);
        int mid = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[0]) {
                mid = i;
                break;
            }
        }
        root.left = buildTree(Arrays.copyOfRange(preorder, 1, mid+1), Arrays.copyOfRange(inorder, 0, mid));
        root.right = buildTree(Arrays.copyOfRange(preorder, mid+1, preorder.length), Arrays.copyOfRange(inorder, mid+1, inorder.length));
        return root;
    }
}
