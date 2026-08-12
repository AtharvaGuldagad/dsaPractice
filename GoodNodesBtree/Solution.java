package GoodNodesBtree;


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
    public int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }
    int dfs(TreeNode node, int maxVal){
        if (node==null) return 0;
        int res= (node.val >= maxVal)? 1:0;
        maxVal=Math.max(node.val, maxVal);
        res= res+dfs(node.left,maxVal);
        res=res+dfs(node.right,maxVal);
        return res;
    }
}

