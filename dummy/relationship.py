'''
Child Parent IsLeft
15 20 true
19 80 true
17 20 false
16 80 false
80 50 false
50 null false
20 50 true


'''


from collections import deque
from collections import defaultdict

class TreeNode:
    def __init__(self, val):
        self.val = val
        self.left = None
        self.right = None   

class Solution:
    def create_tree(self, lst):
        if not lst:
            return None
        id_to_nodes = defaultdict(TreeNode)
        has_parents = set()

        for child, parent, isLeft in lst:
            if child not in id_to_nodes:
                id_to_nodes[child] = TreeNode(child)
            if parent is not None:
                if parent not in id_to_nodes:
                    id_to_nodes[parent] = TreeNode(parent)
                if isLeft:
                    id_to_nodes[parent].left = id_to_nodes[child]
                else:
                    id_to_nodes[parent].right = id_to_nodes[child]
                has_parents.add(child)
        
        for node_id in id_to_nodes:
            if node_id not in has_parents:
                return id_to_nodes[node_id]
            
    def print_tree(self, head):
        if not head:
            print("empty")
            return
        q = deque([head])
        while q:
            level = []
            for _ in range(len(q)):
                node = q.popleft()
                if node:
                    level.append(str(node.val))
                    q.append(node.left)
                    q.append(node.right)
                else:
                    level.append("null")
            while level and level[-1] == "null":
                level.pop()
            if level:
                print(" ".join(level))

relations = [
    [15, 20, True],
    [19, 80, True],
    [17, 20, False],
    [16, 80, False],
    [80, 50, False],
    [50, None, False],
    [20, 50, True],
]

sol = Solution()
root = sol.create_tree(relations)
sol.print_tree(root)