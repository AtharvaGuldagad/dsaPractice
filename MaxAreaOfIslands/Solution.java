package MaxAreaOfIslands;



public class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int cols=grid[0].length, rows=grid.length;
        int maxA=0;
        for(int r=0;r<rows;r++){
            for(int c=0;c<cols;c++){
                if(grid[r][c]==1){
                    int area=dfs(r,c,grid);
                    if(area>maxA) maxA=area;
                }
                
            }
        }
        return maxA;
        
    }
    int dfs(int r,int c,int[][] grid){
        if (r<0 || c<0 || r>=grid.length || c>=grid[0].length || grid[r][c]==0){
            return 0;
        }
        grid[r][c]=0;
        return (1+dfs(r+1,c,grid)+
                  dfs(r-1,c,grid)+
                  dfs(r,c+1,grid)+
                  dfs(r,c-1,grid));

    }
}
