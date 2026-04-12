package ContainsDuplicate;

import java.util.HashMap;

public class Solution {
    public boolean hasDuplicate(int[] nums) {
     HashMap<Integer, Integer> map = new HashMap<>();
     
     for (int i=0;i<nums.length;i++){
        boolean exists = map.containsKey(nums[i]);
        if (exists){
            return true;
        }
        map.put(nums[i],1);
     }  
     return false;
    }
}
