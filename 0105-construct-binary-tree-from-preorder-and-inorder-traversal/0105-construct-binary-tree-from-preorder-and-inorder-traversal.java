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
    int preindex=0;
    Map<Integer, Integer>map= new HashMap<Integer,Integer>();
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
for(int i=0;i<=inorder.length-1;i++){
    map.put(inorder[i],i);
}
        return helper(preorder,inorder, 0,inorder.length-1, 0, preorder.length-1,map );
        
    }
    private TreeNode helper(int[]preorder,int[] inorder, int is,int ie,int ps,int pe,Map<Integer, Integer> map){

        if(is>ie || ps>pe)  return null;

        TreeNode root=new TreeNode(preorder[ps]);
        int inroot=map.get(root.val);
        int nodesleft=inroot-is;

        root.left=helper(preorder,inorder,is,inroot-1,ps+1,ps+nodesleft,map);

        root.right=helper(preorder,inorder,inroot+1,ie,ps+nodesleft+1,pe,map);

        return root;
    }
}