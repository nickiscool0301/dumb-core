'''
Node:
- name
- is_file: bool
- children = {} (name -> Node) = directories
- content = [] list and append content

Model the file system as a tree.
Each directory node stores a hash map (name → child node) for O(1) traversal.
Files and directories use the same node structure, distinguished by an is_file flag.
Paths are processed by splitting on / and walking from root.
Missing directories are created during traversal (like mkdir -p).
File content is stored separately and appended.
Lexicographic order is handled only when listing, not during insertion.
Assume valid input per problem constraints; real FS would reject file–directory conflicts.'''
from typing import List


class Node:
    def __init__(self, name):
        self.name = name
        self.is_file = False
        self.children = {}          # name -> Node: directories
        self.content = []           # only for files



class FileSystem:

    def __init__(self):
        self.root = Node("/")
        
    def ls(self, path: str) -> List[str]:
        node = self._traverse(path) 
        if node.is_file:
            return [node.name] 
        return sorted(node.children.keys())

    def mkdir(self, path: str) -> None:
        curr = self.root 
        parts = path.split("/")
        for part in parts:
            if not part:
                continue
            if part not in curr.children:
                curr.children[part] = Node(part) 
            curr = curr.children[part]
    
    def addContentToFile(self, filePath: str, content: str) -> None:
        curr = self.root 
        parts = filePath.split("/")

        for part in parts[:-1]:
            if not part:
                continue
            if part not in curr.children:
                curr.children[part] = Node(part) 
            curr = curr.children[part] 

        filename = parts[-1]
        if filename in curr.children:
            node = curr.children[filename]
            if not node.is_file:
                raise Exception("Cannot write to a directory")
        else:
            curr.children[filename] = Node(filename)
            curr.children[filename].is_file = True
        if filename not in curr.children:
            curr.children[filename] = Node(filename)
            curr.children[filename].is_file = True
        
        curr.children[filename].content.append(content) 

    def readContentFromFile(self, filePath: str) -> str:
        node = self._traverse(filePath) 
        return "".join(node.content)

    def _traverse(self, path: str) -> Node:
        curr = self.root 
        parts = path.split("/")
        for part in parts:
            if not part:
                continue
            curr = curr.children[part] 
        return curr
        


# Your FileSystem object will be instantiated and called as such:
# obj = FileSystem()
# param_1 = obj.ls(path)
# obj.mkdir(path)
# obj.addContentToFile(filePath,content)
# param_4 = obj.readContentFromFile(filePath)