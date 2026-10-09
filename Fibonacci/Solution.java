package Fibonacci;

public class Solution {

    public int fib(int n) {
        if (n < 2) return n;
        int[] memo = new int[n + 1];
        memo[0] = 0;
        memo[1] = 1;
        return dp(n, memo);

    }

    int dp(int n, int[] memo) {

        for (int i = 2; i <= n; i++) memo[i] = memo[i - 1] + memo[i - 2];
        return memo[n];
    }
}
