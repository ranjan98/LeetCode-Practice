

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

// BFS Approach
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightSideView = new ArrayList<>();
        if(root == null)
            return rightSideView;
        List<TreeNode> queue = new ArrayList<>();
        TreeNode current = root;
        queue.add(current);
        while(queue.size()>0){
            int len = queue.size();
            int count = 0;
            while(count < len){
                current = queue.get(0);
                queue.remove(0);
                if(count == len-1)
                    rightSideView.add(current.val);
                if(current.left!=null)
                    queue.add(current.left);
                if(current.right!=null)
                    queue.add(current.right);
                count++;
            }
        }
        return rightSideView;
    }
}

// Runtime: 1 ms, faster than 76.56% of Java online submissions for Binary Tree Right Side View.
// Memory Usage: 37.6 MB, less than 72.18% of Java online submissions for Binary Tree Right Side View.

// DFS Approach (Order of Traversal: Root Node, Right Node, Left Node)
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightSideView = new ArrayList<>();
        dfs(root, 0, rightSideView);
        return rightSideView;
    }
    public void dfs(TreeNode current, int level, List<Integer> rightSideView){
        if(current == null)
            return;
        if(level >= rightSideView.size())
           rightSideView.add(current.val);
        if(current.right!=null)
            dfs(current.right, level+1, rightSideView);
        if(current.left!=null)
            dfs(current.left, level+1, rightSideView);
    }
}

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Right Side View.
// Memory Usage: 37.4 MB, less than 92.33% of Java online submissions for Binary Tree Right Side View.
