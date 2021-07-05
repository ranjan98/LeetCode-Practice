// Given the root of a binary tree, return its maximum depth.
// A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

// Example 1:
// Input: root = [3,9,20,null,null,15,7]
// Output: 3

// Example 2:
// Input: root = [1,null,2]
// Output: 2

// Example 3:
// Input: root = []
// Output: 0

// Example 4:
// Input: root = [0]
// Output: 1

// Constraints:
//     The number of nodes in the tree is in the range [0, 10^4].
//     -100 <= Node.val <= 100

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
    public int maxDepth(TreeNode root) {
        TreeNode currentNode = root;
        if(currentNode==null)
            return 0;
        return dfs(currentNode, 1);
    }
    // Pre order traversal
    public int dfs(TreeNode node, int max){
        int count1 = max;
        int count2 = max;
        if(node.left!=null)
            count1 = dfs(node.left, max+1);
        if(node.right!=null)
            count2 = dfs(node.right, max+1);
        return Math.max(count1, count2);
    }
}

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Maximum Depth of Binary Tree.
// Memory Usage: 38.7 MB, less than 86.06% of Java online submissions for Maximum Depth of Binary Tree.
