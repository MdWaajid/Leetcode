/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // 1. Get the length of the linked list
        int length = 0;
        ListNode curr = head;
        while (curr != null) {
            length++;
            curr = curr.next;
        }

        // Create a dummy node to ease head manipulation
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // 2. Iterate for step sizes: 1, 2, 4, 8, ...
        for (int step = 1; step < length; step *= 2) {
            ListNode tail = dummy;
            curr = dummy.next; // The remaining part of the list to be sorted

            while (curr != null) {
                // Split the first sublist of size 'step'
                ListNode left = curr;
                ListNode right = split(left, step);
                
                // Split the second sublist of size 'step' and get the remainder
                curr = split(right, step);

                // Merge the two sublists and attach to the sorted tail
                tail.next = merge(left, right);

                // Move tail to the end of the merged sublist
                while (tail.next != null) {
                    tail = tail.next;
                }
            }
        }

        return dummy.next;
    }

    // Splits the list into two parts: the first 'step' nodes, and returns the head of the rest
    private ListNode split(ListNode head, int step) {
        if (head == null) return null;
        
        for (int i = 1; i < step && head.next != null; i++) {
            head = head.next;
        }
        
        ListNode second = head.next;
        head.next = null; // Break the link
        return second;
    }

    // Merges two sorted linked lists and returns the new head and tail connection
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = dummyHead;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }

        if (l1 != null) {
            p.next = l1;
        } else {
            p.next = l2;
        }

        return dummyHead.next;
    }
}