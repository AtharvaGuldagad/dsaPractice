package LrgestAlmostMissingNum;

public class Solution {
    public int largestInteger(int[] nums, int k) {
        int[] f=new int[51];
        for(int x:nums){
            f[x]++;
        }
        int res=-1,n=nums.length;
        for(int i=0;i<n;i++){
            if(k==n||(f[nums[i]]==1 && (k==1||i==0||i==n-1)))
                res=Math.max(res,nums[i]);
        }
        return res;
    }
}
