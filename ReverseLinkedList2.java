// Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list from position left to position right, and return the reversed list.

// Example 1:
// Input: head = [1,2,3,4,5], left = 2, right = 4
// Output: [1,4,3,2,5]

// Example 2:
// Input: head = [5], left = 1, right = 1
// Output: [5]

// Constraints:

//     The number of nodes in the list is n.
//     1 <= n <= 500
//     -500 <= Node.val <= 500
//     1 <= left <= right <= n

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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode prev = head;
        if(prev.next == null || left==right)
            return prev;
        int m = left;
        int n = right;
        ListNode start = prev;
        for(int i=1; i<m; i++){
            if(i==m-1)
                start = prev;
            prev = prev.next;
        }
        ListNode current = prev.next;
        ListNode mPointer = prev;
        for(int i=m; i<n; i++){

            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        mPointer.next = current;
        if(m==1)
            return prev;
        start.next = prev;
        return head;
    }
}

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Reverse Linked List II.
// Memory Usage: 36.5 MB, less than 80.79% of Java online submissions for Reverse Linked List II.
