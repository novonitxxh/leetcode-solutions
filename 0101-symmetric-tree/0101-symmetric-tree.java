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
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode left, TreeNode right) {
        // case 1: both null
        if (left == null && right == null) return true;

        // case 2: one null
        if (left == null || right == null) return false;

        // case 3: values must match + mirror check
        if (left.val != right.val) return false;

        return isMirror(left.left, right.right) &&
               isMirror(left.right, right.left);
    }
}