// Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).

// Example 1:
// Input: root = [3,9,20,null,null,15,7]
// Output: [[3],[9,20],[15,7]]

// Example 2:
// Input: root = [1]
// Output: [[1]]

// Example 3:
// Input: root = []
// Output: []

// Constraints:
//     The number of nodes in the tree is in the range [0, 2000].
//     -1000 <= Node.val <= 1000

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levelOrderList = new ArrayList<>();
        List<TreeNode> queue = new ArrayList<>();
        if(root == null)
            return levelOrderList;
        TreeNode current = root;
        queue.add(current);
        while(queue.size()>0){
            List<Integer> level = new ArrayList<>();
            int len = queue.size();
            int count = 0;
            while(count < len){
                current = queue.get(0);
                queue.remove(0);
                level.add(current.val);
                if(current.left!=null)
                    queue.add(current.left);
                if(current.right!=null)
                    queue.add(current.right);
                count++;
            }
            levelOrderList.add(level);
        }
        return levelOrderList;
    }
}

// Runtime: 1 ms, faster than 61.20% of Java online submissions for Binary Tree Level Order Traversal.
// Memory Usage: 39.1 MB, less than 58.98% of Java online submissions for Binary Tree Level Order Traversal.
