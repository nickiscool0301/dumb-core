class Node:
    def __init__(self,key,val):
        self.key = key
        self.val = val
        self.freq = 1
        self.next = None
        self.prev = None
    
class DoublyLinkedList:
    def __init__(self):
        self.head = Node(-1,-1)
        self.tail = Node(-1,-1)
        self.head.next = self.tail
        self.tail.prev = self.head

    def add_front(self, node):
        next = self.head.next
        self.head.next = node
        node.next = next
        next.prev = node
        node.prev = self.head
    
    def remove(self, node):
        node.prev.next = node.next
        node.next.prev = node.prev

    def pop_tail(self):
        if self.head.next == self.tail:
            return None
        node = self.tail.prev
        self.remove(node)
        return node

    def empty(self):
        return self.head.next == self.tail

from collections import defaultdict
class LFUCache:    
    def __init__(self, capacity: int):
        self.capacity = capacity
        self.key_nodes = {}
        self.freq_nodes = defaultdict(DoublyLinkedList)
        self.min_freq = 0
        self.size = 0

    def put(self, key:int, value:int) -> None:
        '''
        if exist -> update the node with _update, then add to front
        '''
        if self.capacity == 0:
            return
        if key in self.key_nodes:
            node = self.key_nodes[key]
            node.val = value
            self._update(node)
            return
        
        if self.size >= self.capacity:
            old_list = self.freq_nodes[self.min_freq]
            node_to_delete = old_list.pop_tail()
            del self.key_nodes[node_to_delete.key]
            self.size -= 1
        
        new_node = Node(key,value)
        self.key_nodes[key] = new_node
        self.freq_nodes[1].add_front(new_node)
        self.min_freq = 1
        self.size += 1
        
    def get(self, key: int):
        '''
        - not exist return -1
        - get the node
            - update the freq of node: remove the node from freq_nodes
            - if reach 0 -> delete this freq key
                - if we just delete freq equals to min_freq -> update the min_freq
            - else increase the freq and update the freq_nodes (add to front)
        '''
        if key not in self.key_nodes:
            return -1
        node = self.key_nodes[key]
        self._update(node)
        return node.val
    
    def _update(self, node):
        freq = node.freq
        self.freq_nodes[freq].remove(node)
        if self.freq_nodes[freq].empty():
            del self.freq_nodes[freq]
            if freq == self.min_freq:
                self.min_freq += 1
        node.freq += 1
        self.freq_nodes[node.freq].add_front(node)



