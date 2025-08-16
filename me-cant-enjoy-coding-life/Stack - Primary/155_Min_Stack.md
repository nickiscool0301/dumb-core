## URL: https://leetcode.com/problems/min-stack/description/


## Thinking process
- Shouldnt use a stack to implement a Min Stack
- Instead use Node as a linked list
- Create a Node with 3 attributes (val, min and next Node)
- for the MinStack class, just need to have one Node head
- Methods:
  - put: 
    - if head is empty -> create new Node with value
    - else create a Node with val, min = Math.min(val, head.min, head)
  - pop:
    - just set head to head.next
  - top:
    - return the head.val
  - getMin:
    - return the head.min

```java
class MinStack {
    private Node head;

    public MinStack() {
        
    }
    
    public void push(int val) {
        if(head == null) {
            head = new Node(val, val, null);
        } else {
            head = new Node(val, Math.min(head.min, val), head);
        }
        
    }
    
    public void pop() {
        head = head.next;
    }
    
    public int top() {
        return head.val;
        
    }
    
    public int getMin() {
        return head.min;
        
    }

    private class Node {
        int val;
        int min;
        Node next;
            
        private Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
```