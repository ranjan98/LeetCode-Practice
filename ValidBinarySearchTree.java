// Given the root of a binary tree, determine if it is a valid binary search tree (BST).
// A valid BST is defined as follows:
//     The left subtree of a node contains only nodes with keys less than the node's key.
//     The right subtree of a node contains only nodes with keys greater than the node's key.
//     Both the left and right subtrees must also be binary search trees.

// Example 1:
// Input: root = [2,1,3]
// Output: true

// Example 2:
// Input: root = [5,1,4,null,null,3,6]
// Output: false
// Explanation: The root node's value is 5 but its right child's value is 4.

// Constraints:
//     The number of nodes in the tree is in the range [1, 10^4].
//     -2^31 <= Node.val <= 2^31 - 1

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root == null)
            return true;
        long min = Long.MIN_VALUE;
        long max = Long.MAX_VALUE;
        boolean isValid = dfsPreorder(root, min, max);
        return isValid;
    }
    public static boolean dfsPreorder(TreeNode node, long min, long max){   
        if(node.val <= min || node.val >= max){
            return false;
        }
        if(node.left!=null){
            if(dfsPreorder(node.left, min, node.val)==false)
                return false;
        }
        if(node.right!=null){
            if(dfsPreorder(node.right, node.val, max)==false)
                return false;
        } 
        return true;
    }
}

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Validate Binary Search Tree.
// Memory Usage: 38.7 MB, less than 50.39% of Java online submissions for Validate Binary Search Tree.
