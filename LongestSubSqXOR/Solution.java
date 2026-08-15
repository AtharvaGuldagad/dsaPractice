package LongestSubSqXOR;

class Solution {
    public int longestSubsequence(int[] nums) {
        int total=0;
        int n=nums.length;
        boolean zeroFlag=false;
        for(int x:nums){
            zeroFlag= zeroFlag||(x>0);
            total=total^x;

        }
        if(!zeroFlag) return 0;
        return total==0? n-1:n;   
    }
}