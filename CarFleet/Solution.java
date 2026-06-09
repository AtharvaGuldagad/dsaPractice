package CarFleet;

import java.util.Arrays;
import java.util.Stack;

public class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] pair=new int[position.length][2];
        for(int i=0;i<position.length;i++) {
            pair[i][0]=position[i];
            pair[i][1]=speed[i];
        }
        Arrays.sort(pair,(a,b)->Integer.compare(b[0],a[0]));
        Stack<Double> s=new Stack<>();
        for (int[] p:pair) {
            s.push((double) (target - p[0]) / p[1]);
            if (s.size() >= 2 &&
                s.peek() <= s.get(s.size() - 2))
            {
                s.pop();
            }
        }
        return s.size();
    }
}
