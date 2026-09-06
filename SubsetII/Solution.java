package SubsetII;

import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.Arrays;

public class Solution {
    Set<List<Integer>> res=new HashSet<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<Integer> curr = new ArrayList<>();
        backtrack(nums,0,curr);
        return new ArrayList<>(res);
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

