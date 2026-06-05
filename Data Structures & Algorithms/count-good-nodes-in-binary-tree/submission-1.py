# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def goodNodes(self, root: TreeNode) -> int:
        if not root:
            return 0
        return self.helper(root, root.val)

    def helper(self, root: Optional[TreeNode], maxVal: int) -> int:
        if not root:
            return 0
        left = self.helper(root.left, max(maxVal, root.val))
        right = self.helper(root.right, max(maxVal, root.val))
        if(root.val >= maxVal):
            return left + right + 1
        else:
            return left + right