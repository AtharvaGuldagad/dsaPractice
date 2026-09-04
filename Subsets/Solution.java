package Subsets;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> curr = new ArrayList<>();
        backtrack(nums,0,curr);
        return res;
    }
    void backtrack(int[] nums,int ind, List<Integer> curr){
            if(ind>=nums.length){
                res.add(new ArrayList<>(curr));
                return;
            }
            curr.add(nums[ind]);
            backtrack(nums,ind+1,curr);
            curr.remove(curr.size()-1);
            backtrack(nums,ind+1,curr);
        }
}

