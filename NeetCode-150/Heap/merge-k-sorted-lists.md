https://leetcode.com/problems/merge-k-sorted-lists/

# Though process
- input: list of nodes -> need to merge them
- We can easily track the min value in each node inside the input list by using a **HEAP**
- Loop through list -> push to HEAP based on the value (first comparison factor), index (second comprasiion factor), node
- use sentinel node -> res = ListNode() -> dummy = res -> modify on dummy
- why heap -> pop, attach to dummy, make sure to add the next node of current node to the heap for comparision


```python
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        if not lists:
            return None
        heap = []
        for i,node in enumerate(lists):
            if node:
                heapq.heappush(heap,(node.val,i,node))
        
        res = ListNode()
        dummy = res

        while heap:
            _,i,topNode = heapq.heappop(heap)
            dummy.next = topNode
            dummy = dummy.next
            if topNode.next:
                heapq.heappush(heap,(topNode.next.val,i,topNode.next)) 

        return res.next
```