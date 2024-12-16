## URL: https://leetcode.com/problems/lru-cache/description/?envType=company&envId=grab&favoriteSlug=grab-all

## think process
- Use DoublyLinkedList -> Define a class Node with key, value, next Node and prev Node
- Use HashMap<key, Node> for quickly get and put
- Need to have some helper function
  - AddToHead
  - RemoveNode
  - RemoveLRU
  - moveToHead


```java
class LRUCache {

    private class Node {
        int key;
        int value;
        Node next;
        Node prev;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node head;
    private Node tail;
    private int capacity;
    private Map<Integer, Node> hm;


    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.hm = new HashMap<>();
        this.head = new Node(0,0);
        this.tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if(!hm.containsKey(key)) {
            return -1;
        }
        Node node = hm.get(key);
        moveToHead(node);
        return node.value;
        
    }
    
    public void put(int key, int value) {
        if(hm.containsKey(key)) {
            Node node = hm.get(key);
            node.value = value;
            moveToHead(node);
        } else {
            if(hm.size() == capacity) {
                removeLRU();
            } 
            Node newNode = new Node(key, value);
            hm.put(key, newNode);
            addToHead(newNode);
        }
        
    }

    private void removeLRU() {
        Node prevTail = tail.prev;
        hm.remove(prevTail.key);
        removeNode(prevTail);

    }


    private void moveToHead(Node node) {
        removeNode(node);
        addToHead(node);

    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToHead(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */


```