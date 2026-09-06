package Permutation;

import java.util.List;
import java.util.ArrayList;

public class Solution {
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        bktk(new ArrayList<>(),nums,new boolean[nums.length]);
        return res;
    }
    void bktk(List<Integer> curr, int[] nums, boolean[] picked){
        if(curr.size()==nums.length){
            res.add(new ArrayList<>(curr));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!picked[i]){
                curr.add(nums[i]);
                picked[i]=true;
                bktk(curr,nums,picked);
                curr.remove(curr.size()-1);
                picked[i]=false;
            }
        }
    }
}

