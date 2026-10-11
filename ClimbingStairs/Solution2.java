package ClimbingStairs;

public class Solution2 {
    int [] memo;
    public int climbStairs(int n) {
        memo=new int[n];
        for(int i=0;i<n;i++) memo[i]=-1;
        return dfs(n,0);
    }

    int dfs(int n, int i){
        if(i>=n) return i==n?1:0;
        if(memo[i]!=-1) return memo[i];
        return memo[i]=dfs(n,i+1)+dfs(n,i+2);
    }
}

