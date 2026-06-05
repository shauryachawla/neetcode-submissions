# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        if not root:
            return True
        leftHeight = self.height(root.left)
        rightHeight = self.height(root.right)
        if(abs(leftHeight - rightHeight) > 1):
            return False
        return self.isBalanced(root.left) and self.isBalanced(root.right) 
        
    def height(self, root: Optional[TreeNode]) -> int:
        if not root:
            return 0
        left = self.height(root.left)
        right = self.height(root.right)
        return max(left, right) + 1