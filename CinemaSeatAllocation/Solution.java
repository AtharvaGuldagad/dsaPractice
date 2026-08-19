package CinemaSeatAllocation;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int[] a:reservedSeats){
            int row=a[0];
            int seat=a[1];
            if((seat>=2)&&(seat<=9)){
                map.put(row,map.getOrDefault(row,0)|(1<<(seat-2)));
            }
        }
        int left=15;
        int mid=60;
        int right=240;
        int res=(n-map.size())*2;
        for(int mask:map.values()){
            boolean lFlag=(mask&left)==0;
            boolean midFlag=(mask & mid)==0;
            boolean rFlag=(mask & right)==0;
            if(lFlag && rFlag){
                res+=2;
            }else if(lFlag || midFlag || rFlag){
                res++;
            }
        }
        return res;
    }
}
