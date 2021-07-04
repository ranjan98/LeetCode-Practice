// You are given a doubly linked list which in addition to the next and previous pointers, it could have a child pointer, which may or may not point to a separate doubly linked list. These child lists may have one or more children of their own, and so on, to produce a multilevel data structure, as shown in the example below.
// Flatten the list so that all the nodes appear in a single-level, doubly linked list. You are given the head of the first level of the list.

// Example 1:
// Input: head = [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
// Output: [1,2,3,7,8,11,12,9,10,4,5,6]

/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        Node current = head;
        while(current!=null){
            if(current.child!=null){
                Node nxt = current.next;
                Node childfirst = current.child;
                Node childsecond = current.child;
                while(childsecond.next!=null)
                    childsecond = childsecond.next;
                current.next = current.child;
                childfirst.prev = current;
                if(nxt != null){
                    nxt.prev=childsecond;
                }
                childsecond.next = nxt;
                current.child = null;
            }
            current = current.next;
        }
        return head;
    }
}

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Flatten a Multilevel Doubly Linked List.
// Memory Usage: 36.7 MB, less than 95.54% of Java online submissions for Flatten a Multilevel Doubly Linked List.
