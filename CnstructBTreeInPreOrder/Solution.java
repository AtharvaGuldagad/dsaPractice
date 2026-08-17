package CnstructBTreeInPreOrder;

import java.util.HashMap;

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


class Solution {
    int preIdx=0;
    HashMap<Integer, Integer> ind=new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0;i<inorder.length;i++){
            ind.put(inorder[i],i);
        }
        return dfs(preorder, 0 , inorder.length-1);
    }
    TreeNode dfs(int[] preorder, int l, int r){
        if(l>r) return null;
        int root_val=preorder[preIdx++];
        TreeNode root=new TreeNode(root_val);
        int mid=ind.get(root_val);
        root.left=dfs(preorder,l,mid-1);
        root.right=dfs(preorder,mid+1,r);
        return root;
    }
}

