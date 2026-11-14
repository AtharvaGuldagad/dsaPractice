package WallsAndGates;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public void islandsAndTreasure(int[][] grid) {
       Queue<int[]> q= new LinkedList<>();
       int rows=grid.length, cols=grid[0].length;
       for(int r=0;r<rows;r++){
        for(int c=0;c<cols;c++){
            if(grid[r][c]==0) q.offer(new int[]{r,c});
        }
       }

       if(q.size()==0) return;
       
       int[][] directions = {{-1,0},{0,-1},{1,0},{0,1}};

       while(!q.isEmpty()){
        int[] node= q.poll();
        int row=node[0];
        int col=node[1];
        for(int[] dir:directions){
            int r=row+dir[0];
            int c=col+dir[1];
            if(r>=rows||c>=cols||r<0||c<0|| grid[r][c]!=Integer.MAX_VALUE) continue;

            q.add(new int[]{r,c});
            grid[r][c]=grid[row][col]+1;
        }
       }
    }
}

