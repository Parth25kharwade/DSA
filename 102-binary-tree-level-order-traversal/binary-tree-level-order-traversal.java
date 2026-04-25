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
    List<List<Integer>> ans=new ArrayList<>();
    public void order(TreeNode root,int level){
        if(ans.size()==level){
            ans.add(new ArrayList<>());
        }
        ans.get(level).add(root.val);
        if(root.left!=null){
            order(root.left,level+1);
        }
        if(root.right!=null){
            order(root.right,level+1);
        }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null){
            return ans;
        }
        order(root,0);
        return ans;
        
    }
}