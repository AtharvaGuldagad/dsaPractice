package KClosestPointToOrigin;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> minHeap= new PriorityQueue<>(Comparator.comparing(a -> a[0]));
        for(int[] n: points){
            int dist=n[0]*n[0] + n[1]*n[1];
            minHeap.offer(new int[]{dist, n[0], n[1]});
        }
        int [][] res=new int[k][2];
        for(int i=0;i<k;i++){
            int[] n=minHeap.poll();
            res[i]=new int[]{n[1],n[2]};

        }
        return res;
    }
}
