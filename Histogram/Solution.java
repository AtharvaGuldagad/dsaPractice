package Histogram;

import java.util.Stack;

public class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> s=new Stack<>();
        int maxArea=0;
        int n=heights.length;
        for (int i = 0; i <= n; i++) {
            int currentHeight = (i == n) ? 0 : heights[i];
            while (!s.isEmpty() && currentHeight < heights[s.peek()]) {
                int h = heights[s.pop()];
                int w = s.isEmpty() ? i : i - s.peek() - 1;
                maxArea = Math.max(maxArea, h * w);
            }
            s.push(i);
        }
        return maxArea;
    }
}
