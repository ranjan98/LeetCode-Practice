// Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
// There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.
// Notice that you should not modify the linked list.

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

// Using HashSet -> O(n) Space Complexity
public class Solution {
    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> seen = new HashSet<>();
        ListNode current = head;
        if(current==null)
            return null;
        while(seen.contains(current)==false){
            if(current.next == null)
                return null;
            seen.add(current);
            current = current.next;
        }
        return current;
    }
}

// Runtime: 3 ms, faster than 24.24% of Java online submissions for Linked List Cycle II.
// Memory Usage: 40 MB, less than 24.57% of Java online submissions for Linked List Cycle II.

// Using Floyd’s Tortoise and Hare Algorithm (Two Pointers, slow and fast) => O(n) Time Complexity and O(1) Space Complexity
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        if(slow == null || slow.next == null)
            return null;
        while(true){
            fast = fast.next;
            slow = slow.next;
            if(fast == null || fast.next == null)
                return null;
            fast = fast.next;
            if(slow == fast){
                break;
            }
        }
        ListNode current = head;
        while(slow!=current){
            current = current.next;
            slow = slow.next;
        }
        return current;
    }
}

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Linked List Cycle II.
// Memory Usage: 38.9 MB, less than 71.37% of Java online submissions for Linked List Cycle II.
