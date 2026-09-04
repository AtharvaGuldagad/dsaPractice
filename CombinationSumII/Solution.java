package CombinationSumII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    Set<List<Integer>> res=new HashSet<>();
    int sum=0;
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        List<Integer> curr=new ArrayList<>();
        Arrays.sort(nums);
        bktk(curr,0,target,nums,sum);
        return new ArrayList<>(res);
    }
    void bktk(List<Integer> curr,int i,int target,int[] nums,int sum){
        if(sum==target){
            res.add(new ArrayList<>(curr));
            return;
        }
        if(sum>target||i==nums.length) return;
        
        curr.add(nums[i]);
        bktk(curr,i+1,target,nums,sum+nums[i]);
        curr.remove(curr.size()-1);
        while (i+1 < nums.length && nums[i] == nums[i + 1]) {
            i++;
        }
        bktk(curr,i+1,target,nums,sum);
    }
}
