package InvertBTree;

// Definition for a binary tree node.
 class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
 
public class Solution {
    public TreeNode invertTree(TreeNode root) {
        TreeNode temp=new TreeNode();
        if(root==null){ 
            return null;
        }else{
            invertTree(root.left);
            invertTree(root.right);
            temp.left=root.left;
            root.left=root.right;
            root.right=temp.left;
        }
        return root;
    }
}
