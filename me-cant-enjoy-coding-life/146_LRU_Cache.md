## URL: https://leetcode.com/problems/lru-cache/description/?envType=company&envId=grab&favoriteSlug=grab-all

## think process
- Use DoublyLinkedList -> Define a class Node with key, value, next Node and prev Node
- Use HashMap<key, Node> for quickly get and put
- Need to have some helper function
  - AddToHead
  - RemoveNode
  - RemoveLRU
  - moveToHead

## Update 17/1/2025
- To reduce complexity, only need to use two helper functions
  - removeNode(Node node)
  - moveToFront(Node node)
- get: check if cache misses the key -> return -1. Else, create a Node, removeNode(Node) -> moveToFront(Node) -> return node.value
- put: check if cache existed -> If existed -> get the existing Node, update the value -> removeNode -> moveToFront
  - Else, if passing capacity -> removeLastNode by using tail.prev, cache.remove(tail.prev.key), removeNode(tail.prev) -> then create new Node, add to cache, moveToFront

```java
class LRUCache {
  class Node {
    int key;
    int value;
    Node prev;
    Node next;

    public Node(int key, int value) {
      this.key = key;
      this.value = value;
    }
  }

  private Node head;
  private Node tail;
  private Map<Integer, Node> cache;
  private int capacity;

  public LRUCache(int capacity) {
    this.capacity = capacity;
    this.cache = new HashMap<>();
    this.head = new Node(0,0);
    this.tail = new Node(0,0);
    head.next = tail;
    tail.prev = head;
  }


  //get(int key) -> return value
  public int get(int key) {
    if(!cache.containsKey(key)) return -1;
    Node cachedNode = cache.get(key);
    //move to the front
    removeNode(cachedNode);
    moveToFront(cachedNode);
    return cachedNode.value;
  }

  private void removeNode(Node node) {
    node.prev.next = node.next;
    node.next.prev = node.prev;
  }

  private void moveToFront(Node node) {
    node.next = head.next;
    node.prev = head;
    head.next.prev = node;
    head.next = node;
  }


  //put(int key, int value) -> void
  public void put(int key, int value) {
    if(cache.containsKey(key)) {
      Node existedNode = cache.get(key);
      existedNode.value = value;
      removeNode(existedNode);
      moveToFront(existedNode);
    } else {
      if(cache.size() == capacity) {
        Node lastNode = tail.prev;
        cache.remove(lastNode.key);
        removeNode(lastNode);
      }
      Node newNode = new Node(key, value);
      cache.put(key, newNode);
      moveToFront(newNode);
    }
  }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */


```