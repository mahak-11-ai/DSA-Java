
/*
LeetCode 24: Swap Nodes in Pairs

Approach: Iteration + Pointers

Logic:
1. Create a dummy node before head.
2. Take two adjacent nodes: first and second.
3. Update links to swap the nodes.
4. Move prev to first and repeat.

Pointer changes:
first.next = second.next;
second.next = first;
prev.next = second;

Time Complexity: O(n)
Auxiliary Space: O(1)
*/

class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;

        while (prev.next != null && prev.next.next != null) {
            ListNode first = prev.next;
            ListNode second = first.next;

            first.next = second.next;
            second.next = first;
            prev.next = second;

            prev = first;
        }

        return dummy.next;
    }
}

