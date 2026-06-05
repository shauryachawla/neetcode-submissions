# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        return self.dfs(root, -9999, 9999)

    def dfs(self, root, minVal, maxVal) -> bool:
        if not root: return True
        conditions = [self.dfs(root.left, minVal, min(maxVal, root.val)), self.dfs(root.right, max(minVal, root.val), maxVal), root.val > minVal and root.val < maxVal]
        return all(conditions)

        