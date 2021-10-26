class MergeTwoSortedLists {
    // LinkList Node class
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // Initialize result Node, and the pointer to the result
        ListNode result = new ListNode(0);
        ListNode prev = result;

        // While two list node is not null
        while (l1 != null && l2 != null) {

            // find who is smaller then set the pointer of prev to that value
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            // increment the pointer
            prev = prev.next;
        }
        // add the leftover in l1 or l2 to the prev
        prev.next = l1 != null ? l1 : l2;

        // return the final answer
        return result.next;
    }
}