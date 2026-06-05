# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        lo = []
        
        def dfs(root, depth):
            if not root:
                return None
            if(len(lo) == depth):
                lo.append([])
            lo[depth].append(root.val)
            dfs(root.left, depth+1)
            dfs(root.right, depth+1)
        
        dfs(root, 0)
        print(lo)
        res = [l[-1] for l in lo]
        print(res)
        return res