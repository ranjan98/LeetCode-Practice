// Given the root of a complete binary tree, return the number of the nodes in the tree.
// According to Wikipedia, every level, except possibly the last, is completely filled in a complete binary tree, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
// Design an algorithm that runs in less than O(n) time complexity.

// Example 1:
// Input: root = [1,2,3,4,5,6]
// Output: 6

// Example 2:
// Input: root = []
// Output: 0

// Example 3:
// Input: root = [1]
// Output: 1

// Constraints:
//     The number of nodes in the tree is in the range [0, 5 * 10^4].
//     0 <= Node.val <= 5 * 10^4
//     The tree is guaranteed to be complete.

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
    public int countNodes(TreeNode root) {
         if(root==null)
             return 0;
        int height = getHeight(root);
        if(height == 0)
            return 1;
        // Calculate nodes upto height-1 level
        int upperCount = (int)Math.pow(2, height) - 1;
        int left = 0;
        int right = upperCount;
        while(left < right){
            int indexToFind = ((left + right)/2)+1;
            if(nodeExists(indexToFind, height, root)==true)
                left = indexToFind;
            else
                right = indexToFind - 1;
        }
        return upperCount + left + 1;
    }
    public static int getHeight(TreeNode root){
        int height = 0;
        while(root.left!=null){
            root = root.left;
            height++;
        }
        return height;
    }
    public static boolean nodeExists(int indexToFind, int height, TreeNode node){
        int left = 0;
        int right = (int)Math.pow(2, height)-1;
        int count = 0;
        while(count < height){
            int midOfNode = ((left+right)/2)+1;
            if(indexToFind>=midOfNode){
                node = node.right;
                left = midOfNode;
            }
            else{
                node = node.left;
                right = midOfNode-1;
            }
            count++;
        }
        return node!=null;
    }
}

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Count Complete Tree Nodes.
// Memory Usage: 41.4 MB, less than 72.47% of Java online submissions for Count Complete Tree Nodes.
