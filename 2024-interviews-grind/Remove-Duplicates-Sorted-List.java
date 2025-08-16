// Given the head of a sorted linked list,
// delete all duplicates such that each element appears only once.
// Return the linked list sorted as well.

//Input: head = [1,1,2]
//Output: [1,2]

// Idea: transverse through linked list, if find dulplicate, set the next node to the next next one.
// Confused: note that we return head instead of curr so avoid losing the head of input
class Solution {
  public ListNode deleteDuplicates(ListNode head) {
    ListNode cur = head;
    while(cur != null && cur.next != null) {
      if(cur.val == cur.next.val) {
        cur.next = cur.next.next;
      } else cur = cur.next;
    }
    return head;
  }
}