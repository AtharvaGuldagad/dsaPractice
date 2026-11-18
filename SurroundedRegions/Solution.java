package SurroundedRegions;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    int rows, cols;
    int[][] direc=new int[][]{{-1,0},{0,-1},{1,0},{0,1}};
    public void solve(char[][] board) {
        rows=board.length;
        cols=board[0].length;
        capture(board);

        for(int r=0;r<rows;r++){
            for(int c=0;c<cols;c++){
                if(board[r][c]=='O'){
                    board[r][c]='X';
                }else if(board[r][c]=='T'){
                    board[r][c]='O';
                
                }
            }
        }
    }
    void capture(char[][]board){
        Queue<int[]> q=new LinkedList<>();
        for(int r=0;r<rows;r++){
            for(int c=0;c<cols;c++){
                if((r==0||r==rows-1||c==0||c==cols-1)&&board[r][c]=='O'){
                    q.offer(new int[]{r,c});
                }
            }
        }
        while(!q.isEmpty()){
           int[] cell = q.poll();
            int r = cell[0], c = cell[1];
            if (board[r][c] == 'O') {
                board[r][c] = 'T';
                for (int[] direction : direc) {
                    int nr = r + direction[0], nc = c + direction[1];
                    if (nr >= 0 && nr < rows && nc >= 0 && nc < cols) {
                        q.offer(new int[]{nr, nc});
                    }
                }
            }
        }
    }
}
