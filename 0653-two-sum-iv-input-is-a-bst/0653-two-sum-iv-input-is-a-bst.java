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
import java.util.*;

class Solution {
    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> set = new HashSet<>();
        return check(root, k, set);
    }

    public boolean check(TreeNode node, int k, HashSet<Integer> set) {
        // base case
        if (node == null) return false;

        // check complement
        if (set.contains(k - node.val)) return true;

        // store current value
        set.add(node.val);

        // go left OR right
        return check(node.left, k, set) || check(node.right, k, set);
    }
}