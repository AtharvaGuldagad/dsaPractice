package PacificAtlanticFlow;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        Set<List<Integer>> pac = new HashSet<>();
        Set<List<Integer>> atl = new HashSet<>();
        for (int c = 0; c < cols; c++) {
            dfs(0, c, pac, grid[0][c], grid);
            dfs(rows - 1, c, atl, grid[rows - 1][c], grid);
        }
        for (int r = 0; r < rows; r++) {
            dfs(r, 0, pac, grid[r][0], grid);
            dfs(r, cols - 1, atl, grid[r][cols - 1], grid);
        }

        List<List<Integer>> res = new ArrayList<>();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (pac.contains(List.of(r, c)) && atl.contains(List.of(r, c))) {
                    res.add(List.of(r, c));
                }
            }
        }
        return res;
    }

    void dfs(int r, int c, Set<List<Integer>> visited, int prevH, int[][] grid) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length 
            || visited.contains(List.of(r, c)) || grid[r][c] < prevH) {
            return;
        }
        visited.add(List.of(r, c));

        dfs(r + 1, c, visited, grid[r][c], grid);
        dfs(r - 1, c, visited, grid[r][c], grid);
        dfs(r, c + 1, visited, grid[r][c], grid);
        dfs(r, c - 1, visited, grid[r][c], grid);
    }
}