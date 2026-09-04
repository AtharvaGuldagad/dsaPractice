package CombinationSum;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<List<Integer>> res=new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<Integer> curr=new ArrayList<>();
        bktk(curr,0,target,nums);
        return res;
    }
    void bktk(List<Integer> curr,int i,int target,int[] nums){
        if(0==target){
            res.add(new ArrayList<>(curr));
            return;
        }
        if(0>target||i>=nums.length) return;
        
        curr.add(nums[i]);
        bktk(curr,i,target-nums[i],nums);
        curr.remove(curr.size()-1);
        bktk(curr,i+1,target,nums);
    }
}

