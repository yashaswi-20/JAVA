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
    public boolean helper(TreeNode root,int k){
        if(root==null)return false;
        int newTarget=k-root.val;
        
        if(root.left==null && root.right==null){
            if(newTarget==0)return true;
        }
        return helper(root.left,newTarget) || helper(root.right,newTarget);
        
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
       return helper(root,targetSum);
    }
}