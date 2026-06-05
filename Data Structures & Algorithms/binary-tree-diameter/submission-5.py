# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    answer = 0
    def diameterOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        if not root:
            return 0
        left = self.maxHeight(root.left)
        print(f"left: {left}")
        right = self.maxHeight(root.right)
        print(f"left: {right}")
        self.answer = max(self.answer, left + right)
        self.diameterOfBinaryTree(root.left)
        self.diameterOfBinaryTree(root.right)
        return self.answer
    
    def maxHeight(self, root: Optional[TreeNode]) -> int:
        if not root:
            return 0
        left = self.maxHeight(root.left)
        right = self.maxHeight(root.right)
        return max(left, right) + 1
        