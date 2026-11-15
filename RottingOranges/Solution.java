package RottingOranges;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int rows = grid.length, cols = grid[0].length;
        int gud = 0, min = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 2)
                    q.offer(new int[] {r, c});
                if (grid[r][c] == 1)
                    gud += 1;
            }
        }
        int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        while (gud > 0 && !q.isEmpty()) {
            int len=q.size();
            for (int i = 0; i < len; i++) {
                int[] node = q.poll();
                int row = node[0];
                int col = node[1];
                for (int[] dir : directions) {
                    int r = row + dir[0];
                    int c = col + dir[1];
                    if (r < 0 || c < 0 || r >= rows || c >= cols || grid[r][c] != 1)
                        continue;

                    q.offer(new int[] {r, c});
                    grid[r][c] = 2;
                    gud--;
                }
            }
            min++;
        }
        if (gud == 0)
            return min;
        return -1;
    }
}
