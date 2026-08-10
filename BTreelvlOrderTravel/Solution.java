package BTreelvlOrderTravel;

import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            List<Integer> lvl=new ArrayList<>();
            for(int i=q.size();i>0;i--){
                TreeNode node=q.poll();
                if(node!=null){
                    lvl.add(node.val);
                    q.add(node.left);
                    q.add(node.right);
                }
            }
            if(lvl.size()>0) res.add(lvl);
        }
        return res;
    }
}

