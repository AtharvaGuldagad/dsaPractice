import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        List<Integer>[] buckets = new List[nums.length + 1];
        for (int key : map.keySet()) {
            int frequency = map.get(key);  
            if (buckets[frequency] == null) {
                buckets[frequency] = new ArrayList<>();
            }
            buckets[frequency].add(key);
        }
        int[] result = new int[k];
        int index = 0;
        for (int i = buckets.length - 1; i >= 0; i--) {
            if (buckets[i] != null) {
                for (int num : buckets[i]) {
                    result[index] = num;
                    index++;
                    if (index == k) {
                        return result;
                    }
                }
            }
        }
        
        return result;
    }
}