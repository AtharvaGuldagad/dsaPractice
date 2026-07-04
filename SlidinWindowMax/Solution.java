package SlidinWindowMax;

public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        int[] op= new int[n-k+1];
        for(int i=0;i<=n-k;i++){
            int max=nums[i];
            for(int j=i;j<i+k;j++){
                max=Math.max(max,nums[j]);
            }
            op[i]=max;
        }
        return op;
    }
}

