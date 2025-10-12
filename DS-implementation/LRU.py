class Node:
    def __init__(self, key, val):
        self.key = key
        self.val = val
        self.next = None
        self.prev = None

from collections import defaultdict

class LRUCache:

    def __init__(self, capacity: int):
        self.capacity = capacity
        self.key_nodes = defaultdict(Node)
        self.head = Node(-1,-1)
        self.tail = Node(-1,-1)
        self.head.next = self.tail
        self.tail.prev = self.head

    def remove(self, node):
        self.key_nodes.pop(node.key)
        node.next.prev = node.prev
        node.prev.next = node.next
    
    def add_front(self, node):
        self.key_nodes[node.key] = node
        next = self.head.next
        self.head.next = node
        node.prev = self.head
        node.next = next
        next.prev = node

    def get(self, key: int) -> int:
        if key not in self.key_nodes:
            return -1
        node = self.key_nodes[key]
        self.remove(node)
        self.add_front(node)
        return node.val  

    def put(self, key: int, value: int) -> None:
        if key in self.key_nodes:
            self.remove(self.key_nodes[key])
        if len(self.key_nodes) == self.capacity:
            self.remove(self.tail.prev)
        self.add_front(Node(key,value))
        
        


# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)