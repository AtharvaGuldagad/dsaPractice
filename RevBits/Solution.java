package RevBits;

public class Solution {
    public int reverseBits(int n) {
       int res=0;
       for(int i=0;i<32;i++){
        int b=(n>>i)&1;
        res=res+(b<<(31-i));
       } 
       return res;
    }
}