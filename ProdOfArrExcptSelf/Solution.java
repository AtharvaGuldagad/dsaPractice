package ProdOfArrExcptSelf;

import java.util.Arrays;

public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] op = new int[nums.length];
        Arrays.fill(op , 1);
        int j=nums.length-1;
        int pre=1,post=1;
        for(int i=0;i<=nums.length-1;i++){
           op[i]=op[i]*pre;
           pre=pre*nums[i];
           op[j]=post*op[j];
           post=post*nums[j];
           j--;
        }
        return op;
    }
}  
