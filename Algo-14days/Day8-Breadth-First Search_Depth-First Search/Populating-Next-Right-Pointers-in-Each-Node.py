# You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:
# struct Node {
#     int val
#     Node * left
#     Node * right
#     Node * next
# }
# Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
# Initially, all next pointers are set to NULL.

# There are two ways to solve this problem: Iterative/Recursive

'''
# 1: Iterative:

1. Use two pointers: prev to keep track the first node of each row, and curr to traverse through the tree
2. While the prev is not null, set curr equal to prev
    + While the curr is not null and the left node of curr is not null
        . set curr.left.next = curr.right
        . If the curr.next is not null, set the curr.right.next equal to curr.next.left.
        . Then set the curr = curr.next (null or the node that is on the right of the current node)
    + Move the prev to the left node of prev: prev = prev.left
3. Repeat step 3,4,5 until the prev is null
4. Return root

# Instead of using two nested loop, we can apply recursion: divide the tree into 2 parts: left and right then
call the recursion

# 2: Recursive

1. if root is null: return None (base case)
2. if the root.left is not null:
    . set root.left.next = root.right
    . if root.next is not null: set root.right.next = root.next.left
    can recursive for root.left and root.right
3. Return root


'''


# Definition for a Node.
class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next


class Solution:
    def connect(self, root: 'Node') -> 'Node':
        prevNode = root
        while prevNode:
            currNode = prevNode
            while currNode and currNode.left:
                currNode.left.next = currNode.right
                if (currNode.next):
                    currNode.right.next = currNode.next.left
                currNode = currNode.next
            prevNode = prevNode.left
        return root

    def connect_2(self, root: 'Node') -> 'Node':
        if not root:
            return None
        if root.left:
            root.left.next = root.right
            if root.next:
                root.right.next = root.next.left
            self.connect_2(root.left)
            self.connect_2(root.right)
        return root
