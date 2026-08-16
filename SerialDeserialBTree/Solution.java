package SerialDeserialBTree;

import java.util.List;
import java.util.ArrayList;

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

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> res=new ArrayList<>();
        dfsSerial(root,res);
        return String.join(",", res);
    }
    void dfsSerial(TreeNode node, List<String> res){
        if(node==null){
            res.add("N");
            return;
        }
        res.add(String.valueOf(node.val));
        dfsSerial(node.left,res);
        dfsSerial(node.right,res);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] vals=data.split(",");
        int[] i={0};
        return dfsDeserial(vals,i);
    }
    TreeNode dfsDeserial(String[] vals, int[] i){
        if(vals[i[0]].equals("N")){
            i[0]++;
            return null;
    
        }
        TreeNode node=new TreeNode(Integer.parseInt(vals[i[0]]));
        i[0]++;
        node.left=dfsDeserial(vals,i);
        node.right=dfsDeserial(vals,i);
        return node;
    }
}
