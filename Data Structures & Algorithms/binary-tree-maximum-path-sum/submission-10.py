# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    
    def maxPathSum(self, root: Optional[TreeNode]) -> int:
        maxPathSum = -9999
        def dfs(root):
            nonlocal maxPathSum
            if not root:
                return 0
            left = dfs(root.left)
            right = dfs(root.right)
            maxPathSum = max(maxPathSum, (left + right) + root.val, root.val)
            return max(max(left, right) + root.val, 0)
        dfs(root)
        return maxPathSum