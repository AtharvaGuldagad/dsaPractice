package ValidBST;


//Definition for a binary tree node.
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
    public boolean isValidBST(TreeNode root) {
     return dfs(root, -1000000000, 1000000000); 
    }
    boolean dfs(TreeNode node, int left, int right){
        if (node==null) return true;
        if(!(node.val<right && node.val>left)) return false;
        return dfs(node.left, left,node.val)&&dfs(node.right, node.val, right);
    }
}
